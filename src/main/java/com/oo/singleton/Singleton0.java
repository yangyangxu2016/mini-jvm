package com.oo.singleton;

/**
 * 饿汉式(线程安全)
 *
 * @author xyy
 * @create 2017-06-15 16:25
 **/
public class Singleton0 {

    /**
     * 在静态初始化的时候创建单件,确保了线程安全
     */
    private static Singleton0 singleton0 = new Singleton0();

    private Singleton0() {

    }

    /**
     * 已经有实例的直接使用
     * @return
     */
    public static Singleton0 getInstance() {
        return singleton0;
    }

}
