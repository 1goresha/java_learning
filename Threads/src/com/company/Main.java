package com.company;

public class Main {

    public static void main(String[] args) {

        MyTimer myTimer1 = new MyTimer(5);
//        MyTimer myTimer2 = new MyTimer(7);

//        Thread t3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//
//                    myTimer1.showMessageInPeriod();
//                }
//            }
//        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    myTimer1.showMessageInPeriod();
//                    myTimer2.showMessageInPeriod();
                }
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 1; i <= 99; i++) {

                    myTimer1.showTime();
//                    myTimer2.showTime();

//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }

                t2.stop();
//                t3.stop();
            }
        });

        t1.start();
        t2.start();
//        t3.start();

    }
}

class MyTimer {

    int time;
    int period;
    boolean b;

    public MyTimer(int period) {
        this.time = 1;
        this.period = period;
    }

    public synchronized void showTime() {

        if (time % period == 0) {

            try {
                wait();
//                System.out.println("(Поток1) : ждет");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {

            notify();
            System.out.println("(Поток1) : С начала сессии прошло " + time++);
        }
    }

    public synchronized void showMessageInPeriod() {

        if (time % period != 0) {

            try {
                wait();
//                System.out.println("(Поток2) : ждет");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {

            notify();
            System.out.println("(Поток2) : Оповещение : прошло " + time++);
        }
    }

//    public synchronized void showMessageIn7Sec() {
//
//        if (time % 7 != 0) {
//
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        } else {
//
//            System.out.println("(Поток3) : Оповещение : прошло " + time++);
//            notifyAll();
//        }
//    }
}