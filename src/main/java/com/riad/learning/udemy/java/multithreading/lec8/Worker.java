package com.riad.learning.udemy.java.multithreading.lec8;

import java.util.Scanner;

/*
 ** Wait and notify
 * Very much used for synchronizing thread
 */
public class Worker {

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread running....");
            // wait method inherited from object and waits for an indefinite period.
            // two ways: one way among is to notify from the same object of different
            // thread to wake it up another is to regain control of the tread by itself (not clear)
            wait();
            System.out.println("Resumed");
        }
    }

    public void consume() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this) {
            System.out.println("Waiting for return key");
            scanner.nextLine();
            System.out.println("Return key pressed");
            // it will wake from the wait to executing state
            notify();
        }
    }
}
