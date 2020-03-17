package com.ann.test;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAutomicInteger implements Runnable {

    private static volatile int count;
    private static  int count1 = 0;
    private static AtomicInteger count2 = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 100; ++i) {
            count2.getAndIncrement();
            count++;
            count1++;
        }
    }


    public void getCount() {
        System.out.println(count);
        System.out.println(count1);
        System.out.println(count2);
    }

    public static void main(String[] args) {
        TestAutomicInteger testAutomicInteger = new TestAutomicInteger();
        for (int i = 0; i < 20; ++i) {
            Thread thread = new Thread(testAutomicInteger);
            thread.start();
        }
        System.out.println("Thread count:" + Thread.activeCount());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread count:" + Thread.activeCount());
        testAutomicInteger.getCount();
    }
}
