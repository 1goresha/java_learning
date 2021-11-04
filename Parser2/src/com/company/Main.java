package com.company;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here

        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>();
        File file = new File("warAndPeace.txt");

        Producer producer = new Producer(blockingQueue, file);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
