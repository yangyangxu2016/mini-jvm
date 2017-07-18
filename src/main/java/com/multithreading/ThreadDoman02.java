package com.multithreading;

/**
 * @author xyy
 * @create 2017-06-22 15:09
 **/
public class ThreadDoman02 {


    public synchronized void methodA() throws InterruptedException {
        System.out.println("begin methodA , threadName = " + Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("end methodA , threadName = " + Thread.currentThread().getName());
    }


    public synchronized void methodB() throws InterruptedException {

        System.out.println("begin methodB ,threadName = " + Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("end methodB  , threadName = " + Thread.currentThread().getName());

    }


    public static void main(String[] args) {

        ThreadDoman02 td1 = new ThreadDoman02();
        ThreadDoman02 td2 = new ThreadDoman02();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    td1.methodA();
//                    td1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    td1.methodB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程B").start();



    }




}
