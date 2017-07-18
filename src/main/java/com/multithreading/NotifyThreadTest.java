package com.multithreading;

/**
 * notify()方法不释放锁
 * @author xyy
 * @create 2017-06-22 14:01
 **/
public class NotifyThreadTest extends Thread {
    private Object lock;

    public NotifyThreadTest(Object lock) {
        this.lock = lock;
    }


    public void run() {
        synchronized (lock) {
            System.out.println("开始------ notify time =" + System.currentTimeMillis());
            lock.notify();
            System.out.println("结束-------nitify time =" + System.currentTimeMillis());

//脏读
        }

    }
}

