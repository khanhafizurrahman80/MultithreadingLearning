package com.riad.learning.udemy.java.multithreading.lec8;

public class App {
    public static void main(String[] args) {

        final Worker worker = new Worker();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    worker.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    worker.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
