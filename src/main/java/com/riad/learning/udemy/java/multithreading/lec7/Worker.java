package com.riad.learning.udemy.java.multithreading.lec7;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * Producer and consumer class.
 * All class in concurrent are by default thread safe.
 * Hence thread safe, the program will not crush because if the queue is full then put will not executed
 * and similar for take in reverse situation.
 * Hence consumer is waiting for  1/100 th of sleep therefore the queue will be filled up really very fast
 * and also if condition is another reason for making it delay
 */
public class Worker {
    public BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public void producer() {
        Random random = new Random();

        while (true){
            try {
                queue.put(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consumer(){
        Random random = new Random();

        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int value = 0;
            if (random.nextInt(10) == 0){
                try {
                    value = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Taken value: " + value + "; Queue size is: " + queue.size() );
            }
        }
    }
}
