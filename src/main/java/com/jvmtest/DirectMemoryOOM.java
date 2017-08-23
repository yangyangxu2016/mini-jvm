package com.jvmtest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 *
 * @author xyy
 * @create 2017-08-15 8:49
 **/
public class DirectMemoryOOM {


    private static final int _MB = 1024 * 1024;


    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_MB);
        }
    }


}
