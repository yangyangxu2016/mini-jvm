package com.jvmtest;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 借助CGLib使方法区出现内存溢出异常
 *
 *  VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * @author xyy
 * @create 2017-08-15 9:15
 **/
public class JavaMethodAreaOOM {


    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });

            enhancer.create();

        }
    }

    static class OOMObject {

    }
}
