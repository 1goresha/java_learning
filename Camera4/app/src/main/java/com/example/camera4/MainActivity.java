package com.example.camera4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;


import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.net.rtp.AudioGroup;
import android.net.rtp.RtpStream;
import android.os.Build;
import android.os.Bundle;


import android.os.Handler;
import android.os.HandlerThread;
import android.os.StrictMode;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.net.SocketException;
import java.nio.ByteBuffer;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {


    public static final String LOG_TAG = "myLogs";
    public static Surface surface = null;

    CameraService[] myCameras = null;

    private CameraManager mCameraManager = null;
    private final int CAMERA1 = 0;
    private Button mButtonOpenCamera1 = null;

    private Button mButtonTStopStreamVideo = null;
    public static TextureView mImageViewUp = null;
    public static TextureView mImageViewDown = null;
    private HandlerThread mBackgroundThread;
    private Handler mBackgroundHandler = null;

    private MediaCodec encoder = null; // кодер
    private MediaCodec decoder = null;

    byte[] b;
    Surface mEncoderSurface; // Surface как вход данных для кодера
    Surface mDecoderSurface; // Surface как прием данных от кодера

    ByteBuffer outPutByteBuffer;
    ByteBuffer decoderInputBuffer;
    ByteBuffer decoderOutputBuffer;

    byte outDataForEncoder[];

    DatagramSocket udpSocket;
    DatagramSocket udpSocketIn;
    String ip_address = "192.168.0.101";    // сюда пишете IP адрес телефона куда шлете //видео, но можно и себе
//    String ip_address = "192.168.0.186";    // сюда пишете IP адрес телефона куда шлете //видео, но можно и себе
    InetAddress address;
    int port = 5004;

    ByteArrayOutputStream out;


    private void startBackgroundThread() {
        mBackgroundThread = new HandlerThread("CameraBackground");
        mBackgroundThread.start();
        mBackgroundHandler = new Handler(mBackgroundThread.getLooper());
    }

    private void stopBackgroundThread() {
        mBackgroundThread.quitSafely();
        try {
            mBackgroundThread.join();
            mBackgroundThread = null;
            mBackgroundHandler = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        setContentView(R.layout.activity_main);


        Log.d(LOG_TAG, "Запрашиваем разрешение");


        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                ||
                (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)


        ) {
            requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }


        mButtonOpenCamera1 = findViewById(R.id.button1);

        mButtonTStopStreamVideo = findViewById(R.id.button3);
        mImageViewUp = findViewById(R.id.textureView);
        mImageViewDown = findViewById(R.id.textureView3);


        mButtonOpenCamera1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setUpMediaCodec();// инициализируем Медиа Кодек

                if (myCameras[CAMERA1] != null) {// открываем камеру
                    if (!myCameras[CAMERA1].isOpen()) {
                        myCameras[CAMERA1].openCamera();
                        Toast.makeText(MainActivity.this, myCameras[CAMERA1].toString(), Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });


        mButtonTStopStreamVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (encoder != null) {

                    Toast.makeText(MainActivity.this, " остановили стрим", Toast.LENGTH_SHORT).show();
                    myCameras[CAMERA1].stopStreamingVideo();
                }


            }
        });


        try {
            udpSocket = new DatagramSocket();
            udpSocketIn = new DatagramSocket(port);// we changed it to DatagramChannell becouse UDP packets may be different in size
            try {

            } catch (Exception e) {
                Log.i(LOG_TAG, "  создали udp канал");
            }


            new Udp_recipient();

            Log.i(LOG_TAG, "  создали udp сокет");

        } catch (
                SocketException e) {
            Log.i(LOG_TAG, " не создали udp сокет");
        }

        try {
            address = InetAddress.getByName(ip_address);
            Log.i(LOG_TAG, "  есть адрес = " + address);
        } catch (Exception e) {


        }


        mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            // Получение списка камер с устройства

            myCameras = new CameraService[mCameraManager.getCameraIdList().length];

            for (String cameraID : mCameraManager.getCameraIdList()) {
                Log.i(LOG_TAG, "cameraID: " + cameraID);
                int id = Integer.parseInt(cameraID);
                // создаем обработчик для камеры
                myCameras[id] = new CameraService(mCameraManager, cameraID);

            }
        } catch (CameraAccessException e) {
            Log.e(LOG_TAG, e.getMessage());
            e.printStackTrace();
        }

    }


    public class CameraService {


        private String mCameraID;
        private CameraDevice mCameraDevice = null;
        private CameraCaptureSession mSession;
        private CaptureRequest.Builder mPreviewBuilder;

        public CameraService(CameraManager cameraManager, String cameraID) {

            mCameraManager = cameraManager;
            mCameraID = cameraID;

        }


        private CameraDevice.StateCallback mCameraCallback = new CameraDevice.StateCallback() {

            @Override
            public void onOpened(CameraDevice camera) {
                mCameraDevice = camera;
                Log.i(LOG_TAG, "Open camera  with id:" + mCameraDevice.getId());

                startCameraPreviewSession();
            }

            @Override
            public void onDisconnected(CameraDevice camera) {
                mCameraDevice.close();

                Log.i(LOG_TAG, "disconnect camera  with id:" + mCameraDevice.getId());
                mCameraDevice = null;
            }

            @Override
            public void onError(CameraDevice camera, int error) {
                Log.i(LOG_TAG, "error! camera id:" + camera.getId() + " error:" + error);
            }
        };

        private void startCameraPreviewSession() {
            SurfaceTexture texture = mImageViewUp.getSurfaceTexture();
            texture.setDefaultBufferSize(640, 480);
            surface = new Surface(texture);


            try {

                mPreviewBuilder = mCameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);

                mPreviewBuilder.addTarget(surface);

                mPreviewBuilder.addTarget(mEncoderSurface);


                mCameraDevice.createCaptureSession(Arrays.asList(surface, mEncoderSurface),

                        new CameraCaptureSession.StateCallback() {

                            @Override
                            public void onConfigured(CameraCaptureSession session) {
                                mSession = session;

                                try {
                                    mSession.setRepeatingRequest(mPreviewBuilder.build(), null, mBackgroundHandler);
                                } catch (CameraAccessException e) {
                                    Log.e("ERRRRRRRRRROR!!!", "original error1 = " + e.getMessage());
//                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onConfigureFailed(CameraCaptureSession session) {
                                Log.e("ERRRRRRRRRROR!!!", "onConfigureFailed!!!");
                            }
                        }, mBackgroundHandler);
            } catch (CameraAccessException e) {
                Log.e("ERRRRRRRRRROR!!!", "original error3 = " + e.getMessage());
//                e.printStackTrace();
            }

        }


        public boolean isOpen() {
            if (mCameraDevice == null) {
                return false;
            } else {
                return true;
            }
        }


        @RequiresApi(api = Build.VERSION_CODES.M)
        public void openCamera() {
            try {

                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {

                    mCameraManager.openCamera(mCameraID, mCameraCallback, mBackgroundHandler);

                }

            } catch (CameraAccessException e) {
                Log.i(LOG_TAG, e.getMessage());

            }
        }

        public void closeCamera() {

            if (mCameraDevice != null) {
                mCameraDevice.close();
                mCameraDevice = null;
            }
        }

        public void stopStreamingVideo() {

            if (mCameraDevice != null & encoder != null) {

                try {
                    mSession.stopRepeating();
                    mSession.abortCaptures();
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }

                encoder.stop();
                encoder.release();
                mEncoderSurface.release();
                decoder.stop();
                decoder.release();


                closeCamera();
            }
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setUpMediaCodec() {


        try {
            encoder = MediaCodec.createEncoderByType("video/avc"); // H264 кодек

        } catch (Exception e) {
            Log.i(LOG_TAG, "а нету кодека");
        }
        {
            int width = 640; // ширина видео
            int height = 480; // высота видео
            int colorFormat = MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface; // формат ввода цвета
            int videoBitrate = 2000000; // битрейт видео в bps (бит в секунду)
            int videoFramePerSecond = 30; // FPS
            int iframeInterval = 1; // I-Frame интервал в секундах

            MediaFormat format = MediaFormat.createVideoFormat("video/avc", width, height);
            format.setInteger(MediaFormat.KEY_COLOR_FORMAT, colorFormat);
            format.setInteger(MediaFormat.KEY_BIT_RATE, videoBitrate);
            format.setInteger(MediaFormat.KEY_FRAME_RATE, videoFramePerSecond);
            format.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, iframeInterval);

            encoder.configure(format, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE); // конфигурируем кодек как кодер
            mEncoderSurface = encoder.createInputSurface(); // получаем Surface кодера
        }
        encoder.setCallback(new EncoderCallback());
        encoder.start(); // запускаем кодер
        Log.i(LOG_TAG, "запустили кодек");


        try {

            decoder = MediaCodec.createDecoderByType("video/avc");// H264 декодек


        } catch (Exception e) {
            Log.i(LOG_TAG, "а нету декодека");
        }

        int width = 640; // ширина видео
        int height = 480; // высота видео


        MediaFormat format = MediaFormat.createVideoFormat("video/avc", width, height);

        format.setInteger(MediaFormat.KEY_ROTATION, 90);
        SurfaceTexture texture = mImageViewDown.getSurfaceTexture();
        texture.setDefaultBufferSize(640, 480);
        mDecoderSurface = new Surface(texture);

        decoder.configure(format, mDecoderSurface, null, 0);
        decoder.setOutputSurface(mDecoderSurface);


        decoder.setCallback(new DecoderCallback());
        decoder.start();
        Log.i(LOG_TAG, "запустили декодер");
    }

    //CALLBACK FOR DECODER
    private class DecoderCallback extends MediaCodec.Callback {

        @Override
        public void onInputBufferAvailable(MediaCodec codec, int index) {
            decoderInputBuffer = codec.getInputBuffer(index);
            decoderInputBuffer.clear();

            synchronized (out) {
                b = out.toByteArray();
                out.reset();
            }
            decoderInputBuffer.put(b);
            codec.queueInputBuffer(index, 0, b.length, 0, 0);   //массив байтов кладем в очередь кодека

        }

        @Override
        public void onOutputBufferAvailable(MediaCodec codec, int index, MediaCodec.BufferInfo info) {
            {
                {
                    decoderOutputBuffer = codec.getOutputBuffer(index);         //вынимаем данные(массив данных)
                    codec.releaseOutputBuffer(index, true);             //отправляем на Surface
                }
            }
        }

        @Override
        public void onError(MediaCodec codec, MediaCodec.CodecException e) {
            Log.i(LOG_TAG, "Error: " + e);
        }

        @Override
        public void onOutputFormatChanged(MediaCodec codec, MediaFormat format) {
            Log.i(LOG_TAG, "decoder output format changed: " + format);
        }
    }

    private class EncoderCallback extends MediaCodec.Callback {

        @Override
        public void onInputBufferAvailable(MediaCodec codec, int index) {
            Log.i(LOG_TAG, " входные буфера готовы");
            //


        }

        @Override
        public void onOutputBufferAvailable(MediaCodec codec, int index, MediaCodec.BufferInfo info) {


            outPutByteBuffer = encoder.getOutputBuffer(index);


            byte[] outDate = new byte[info.size];
            outPutByteBuffer.get(outDate);


            try {

                DatagramPacket packet = new DatagramPacket(outDate, outDate.length, address, port);
                udpSocket.send(packet);
            } catch (IOException e) {
                Log.i(LOG_TAG, " не отправился UDP пакет");
            }

            encoder.releaseOutputBuffer(index, false);


        }

        @Override
        public void onError(MediaCodec codec, MediaCodec.CodecException e) {
            Log.i(LOG_TAG, "Error: " + e);
        }

        @Override
        public void onOutputFormatChanged(MediaCodec codec, MediaFormat format) {
            //  Log.i(LOG_TAG, "encoder output format changed: " + format);
        }
    }

    @Override
    public void onPause() {
        if (myCameras[CAMERA1].isOpen()) {
            myCameras[CAMERA1].closeCamera();
        }

        stopBackgroundThread();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        startBackgroundThread();
    }


    //отдельный поток для приема дэйтаграмм по UDP
    //отдельный потому что мы не знаем, когда придут слудующие дэйтаграммы
    public class Udp_recipient extends Thread {

        Udp_recipient() {
            out = new ByteArrayOutputStream(50000);
            start();

        }

        public void run() {
            while (true) {
                try {
                    byte buffer[] = new byte[50000];
                    DatagramPacket p = new DatagramPacket(buffer, buffer.length);
                    udpSocketIn.receive(p);
                    byte bBuffer[] = p.getData();
                    outDataForEncoder = new byte[p.getLength()];

                    synchronized (outDataForEncoder) {
                        for (int i = 0; i < outDataForEncoder.length; i++) {
                            outDataForEncoder[i] = bBuffer[i];
                        }
                    }
                    synchronized (out) {
                        out.write(outDataForEncoder);
                    }

                } catch (Exception e) {
                    Log.i(LOG_TAG, e + "  ");
                }
            }
        }
    }


}