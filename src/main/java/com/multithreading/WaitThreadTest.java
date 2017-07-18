package com.multithreading;

/**
 * @author xyy
 * @create 2017-06-22 13:59
 **/
public class WaitThreadTest extends Thread {


    private Object lock;

    public WaitThreadTest(Object lock) {
        this.lock = lock;
    }


    public void run() {
        synchronized (lock) {
            System.out.println("开始---------wait  time = " + System.currentTimeMillis());
            try {
                lock.wait();
                System.out.println("结束------wait time = " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
