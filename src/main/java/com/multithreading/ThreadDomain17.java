package com.multithreading;

/**
 * @author xyy
 * @create 2017-06-22 15:47
 **/
public class ThreadDomain17 {

    public synchronized void testMethod() throws InterruptedException {
        System.out.println("enter threadDomain17.testMethod ,currentThread = " + Thread.currentThread().getName());
//        long a = Integer.MAX_VALUE;
        long a = 100;


        while (true) {
            long lo = 2 / a;
            Thread.sleep(1);
            a--;
            System.out.println(a);

        }
    }


    public static void main(String[] args) {
        ThreadDomain17 td1 = new ThreadDomain17();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    td1.testMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    td1.testMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }



}
