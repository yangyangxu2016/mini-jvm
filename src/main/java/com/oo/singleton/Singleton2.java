package com.oo.singleton;

/**
 * 懒汉式(线程安全之synchronized关键字)
 *
 * @author xyy
 * @create 2017-06-15 16:17
 **/
public class Singleton2 {

    private   static Singleton2 singleton2;


    private Singleton2() {

    }

    /**
     * 1.降低性能
     * 2.通过增加synchronized关键字,确保每个线程在进入这个方法之前.要等候别的线程离开这个方法
     * 3.其实只有第一次执行这个方法才需要同步,以后再次调用就不需要了,同步是一个累赘
     * @return
     */
    public  static synchronized Singleton2 getInstance() {
        if (singleton2 == null) {
            return new Singleton2();
        }
        return singleton2;
    }



}
