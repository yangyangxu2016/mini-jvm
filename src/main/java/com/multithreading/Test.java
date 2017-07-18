package com.multithreading;

/**
 * @author xyy
 * @create 2017-06-22 14:04
 **/
public class Test {


    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        WaitThreadTest waitThreadTest = new WaitThreadTest(lock);
        waitThreadTest.start();
        Thread.sleep(3000);
        NotifyThreadTest noticeThreadTest = new NotifyThreadTest(lock);
        noticeThreadTest.start();

    }
}
