package com.oo.singleton;

/**
 * 懒汉式(线程安全之双重检查锁)
 *不适用与1.4及其下版本
 * @author xyy
 * @create 2017-06-15 16:22
 **/
public class Singleton3 {

    /**
     * volatile关键字singleton3被初始化后,多个线程正确的处理singleton3;
     */
    private volatile static Singleton3 singleton3;

    private Singleton3() {

    }

    /**
     * 1.首先检查实例是否创建了,如果尚未创建,才进行同步,这样一来,只有第一次创建实例时会同步
     *
     * @return
     */
    public static Singleton3 getInstance() {
        //1.检查实例,如果不存在,就进入同步区块
        if (singleton3 == null) {
            //2.只有第一次才执行这里的代码
            synchronized (Singleton3.class) {
                //3.进入区块后,在检查一次,如果仍为空,创建实例
                if (singleton3 == null) {
                    return new Singleton3();
                }
            }
        }
        return singleton3;

    }

}
