package com.oo.singleton;

/**
 * 懒汉式(线程不安全)
 * @author xyy
 * @create 2017-06-15 16:06
 **/
public class Singleton1 {
    /**
     * 利用一个静态变量记录Singleton1的唯一实例
     */
    private static Singleton1 singleton1;

    /**
     * 把构造器声明为私有的,只有SingLeon1的内部才可以调用构造器
     */
    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        //null.表明还没有创建实例
        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }
        //不为null,直接返回
        return singleton1;
    }


    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton2 = Singleton1.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1.equals(singleton2));


    }
}
