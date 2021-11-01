package com.company;

public class Main {

    public static void main(String[] args) {

        MyTimer myTimer = new MyTimer();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    myTimer.showMessageIn7Sec();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    myTimer.showMessageIn5Sec();
                }
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 1; i <= 99; i++) {

                    myTimer.showTime();
                }

                t2.stop();
                t3.stop();
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }
}

class MyTimer {

    int time;

    public MyTimer() {
        this.time = 1;

    }

    public synchronized void showTime() {

        if (time % 5 == 0 || time % 7 == 0) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("(Поток1) : С начала сессии прошло " + time);
            notifyAll();
            time++;
        }
    }

    public synchronized void showMessageIn5Sec() {

        if (time % 5 != 0) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {

            System.out.println("(Поток2) : Оповещение : прошло " + time);
            notifyAll();
            time++;
        }
    }

    public synchronized void showMessageIn7Sec() {

        if (time % 7 != 0) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {

            System.out.println("(Поток3) : Оповещение : прошло " + time);
            notifyAll();
            time++;
        }
    }
}