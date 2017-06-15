package com.oo.singleton;

/**
 * 静态内部类实现单例(线程安全)
 *
 * @author xyy
 * @create 2017-06-15 16:49
 **/
public class Singleton4 {

    /**
     *1.类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例;
     * 2.没有绑定关系，而且只有被调用到时才会装载，从而实现了延迟加载。
     */
    private Singleton4() {
    }

    private static class SingletonHolder {

        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static Singleton4 singleton4 = new Singleton4();

        public static Singleton4 getInstance() {
            return SingletonHolder.singleton4;
        }

    }


    public static void main(String[] args) {
        /**
         * 1.当getInstance方法第一次被调用的时候，它第一次读取SingletonHolder.instance，导致SingletonHolder类得到初始化；
         * 2.而这个类在装载并被初始化的时候，会初始化它的静态域，从而创建Singleton的实例，
         * 3.由于是静态的域，因此只会在虚拟机装载类的时候初始化一次，并由虚拟机来保证它的线程安全性
         */
        Singleton4 singleton41 = Singleton4.SingletonHolder.getInstance();
        Singleton4 singleton42 = Singleton4.SingletonHolder.getInstance();
        System.out.println(singleton41 == singleton42);
        System.out.println(singleton41.equals(singleton42));
    }
}
