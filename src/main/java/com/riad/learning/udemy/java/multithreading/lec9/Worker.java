package com.riad.learning.udemy.java.multithreading.lec9;

import java.util.LinkedList;
import java.util.Random;

/*
 * a class to synchronise manually using wait and notify
 */
public class Worker {

    private LinkedList<Integer> list = new LinkedList<Integer>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void produce() throws InterruptedException {

        int value = 0;

        while (true) {
            synchronized (this) {

                if (list.size() == LIMIT) {
                   wait();
                }

                list.add(value++);
                notify();

            }
        }

    }

    public void consume() throws InterruptedException {

        Random random = new Random();

        while (true) {

            synchronized (this) {

                if (list.size() == 0){
                   wait();
                }
                System.out.print("List size is: " + list.size());
                System.out.println("; value is: " + list.removeFirst());
                notify();
            }

            Thread.sleep(random.nextInt(1000));
        }
    }


}
