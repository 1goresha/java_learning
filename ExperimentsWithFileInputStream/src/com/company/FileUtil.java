package com.company;

import java.io.*;

public class FileUtil {
    private String file;

    public FileUtil(String file) {
        this.file = file;
    }

    public void readStreamFromFile() {
        try {
            InputStream fileInputStream = new FileInputStream(this.file);
            int temp = fileInputStream.read();
            while (temp != -1) {
                System.out.println((char)temp);
                temp = fileInputStream.read();
            }
        } catch (IOException e) {
            System.out.println("file is not founded");
//            throw new IllegalArgumentException();
        }
    }
}
