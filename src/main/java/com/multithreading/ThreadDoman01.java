package com.multithreading;

/**
 * 对象锁
 * @author xyy
 * @create 2017-06-22 14:55
 **/
public class ThreadDoman01 {


    private int num = 0;

    public synchronized void addNum(String userName) throws InterruptedException {
        if ("a".equals(userName)) {
            num = 100;
            System.out.println("a set over! ");
            Thread.sleep(2000);
        } else {
            num = 200;
            System.out.println("b set over");

        }
        System.out.println(userName + "num = " + num);
    }


    public static void main(String[] args) {

        ThreadDoman01 td = new ThreadDoman01();
        ThreadDoman01 td1 = new ThreadDoman01();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    td.addNum("a");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "线程1").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    td1.addNum("b");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程2").start();
    }


}
