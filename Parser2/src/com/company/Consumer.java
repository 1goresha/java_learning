package com.company;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {

        int i = 0;
        String word = "";

        while (true) {

            try {
                word = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (word.equals("-1")) {

                return;
            }

            System.out.println("get <-" + ++i + " : " + word);
        }


    }
}
