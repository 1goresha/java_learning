package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue<String> queue;
    private final File file;

    public Producer(BlockingQueue<String> queue, File file) {

        this.queue = queue;
        this.file = file;
    }


    @Override
    public void run() {

        FileReader fileReader;
        BufferedReader bufferedReader = null;

        Scanner scanner = new Scanner(System.in);

        int i = 0;

        while (i == 0) {

            System.out.println("¬ведите слово дл€ поиска : ");
            String word = scanner.next();

            try {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            String s = "";

            if (bufferedReader != null) {

                try {
                    s = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                while (s != null) {

                    try {
                        if (s.toLowerCase().contains(word.toLowerCase())) {

                            queue.put(word);
                            System.out.println("put ->" + ++i + " : " + word);
                        }

                        s = bufferedReader.readLine();
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    queue.put("-1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
