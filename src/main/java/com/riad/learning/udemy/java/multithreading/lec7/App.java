package com.riad.learning.udemy.java.multithreading.lec7;

public class App {
    public static void main(String[] args) {

        final Worker worker = new Worker();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                worker.producer();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                worker.consumer();
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
