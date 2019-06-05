package com.riad.learning.udemy.java.multithreading.lec4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

    private Random random = new Random();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();


    public void stageOne(){

        // synchronized code block
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list1.add(random.nextInt(100));
    }


    public void stageTwo(){

        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list2.add(random.nextInt(100));
    }


    public void process(){

        for (int i = 0; i <1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    /*
     * - Error 1:You will get an error: because two thread is trying to share the same resources
     * - Solution 1: synchronized
     * - Sol 1 will lock everything related with the worker object and now we need 2x time but hence
     * both method writes data to diff location therefore it should run
     * - Sol 2: use lock object; the reason it worked because now the two individual objects
     * are locked instead of worker object so two threads of worker can enter into the method at the
     * same time but when entered into the synchronized block now object class is locked
     */
    public void main() {
        System.out.println("Starting....");

        long start = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                process();
            }
        });

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                process();
            }
        });

        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("Time take: " + (end - start));
        System.out.println("List 1" + list1.size() + "; List2: " + list2.size());
    }
}
