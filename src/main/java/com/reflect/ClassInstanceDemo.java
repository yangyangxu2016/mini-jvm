package com.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;


public class ClassInstanceDemo {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {


        //1、获得Class对象

        //   直接获取某一个对象的class，比如:
        Class clz1 = Date.class;
        Class<?> klass = int.class;
        Class<?> classInt = Integer.TYPE;

        // 调用某个对象的getClass()方法,比如:
        Date date = new Date();
        Class clz2 = date.getClass();
        //使用Class类的forName静态方法:
        Class clz3 = Class.forName("java.util.Date");

        System.out.println(clz1 == clz2);//ture
        System.out.println(clz2 == clz3);//ture
        System.out.println(clz1.equals(clz2));//ture

        //************************************我是华丽的分割线******************************************************


        //2. 判断是否为某个类的实例
        //一般地，我们用instanceof关键字来判断是否为某个类的实例。
        // 同时我们也可以借助反射中Class对象的isInstance()方法来判断是否为某个类的实例，它是一个Native方法：
        Class user1 = User.class;
        User user2 = new User();
        System.out.println("判断User对象user2是不是Class类型user1的实例：  " + user1.isInstance(user2));


        //************************************我是华丽的分割线******************************************************

        //3、创建实例
        //1.使用Class对象的newInstance方法来创建某个类的实例
        Class user3 = User.class;
        user3.newInstance();
        //2.用指定的构造器获取类的实例
        Class user4 = User.class;
        Constructor userConstructor = user4.getConstructor(String.class, String.class);
        Object o = userConstructor.newInstance("名字", "年龄");
        System.out.println("user4的实例： " + o.toString());

        //************************************我是华丽的分割线******************************************************


        //================通过反射获取字段                    =====================================

        //  all the accessible public fields of the class or interface represented by this  Class object.
        Class c = User.class;
        Field[] pubfields = c.getFields();
        System.out.println("公共的包括继承字段的个数： " + pubfields.length);
        for (Field f : pubfields) {
            System.out.println("公共的包括继承字段名称：  " + f);
        }
        //  This includes public, protected, default (package) access, and private fields, but excludes inherited fields.
        Field[] prifields = c.getDeclaredFields();
        System.out.println("本类中所有不包括继承字段的个数： " + prifields.length);
        for (Field f : prifields) {
            System.out.println("本类中所有不包括继承字段名称：  " + f);
        }


        //************************************我是华丽的分割线******************************************************


        //================通过反射获取方法                   =====================================

        Method[] pubMethods = c.getMethods();
        System.out.println("公共的包括继承方法的个数： " + pubMethods.length);
        for (Method m : pubMethods) {
            System.out.println("公共的包括继承方法名称：  " + m);

        }


        Method[] priMethods = c.getDeclaredMethods();
        System.out.println("本类中所有不包括继承方法的个数： " + priMethods.length);
        for (Method m : priMethods) {
            System.out.println("本类中所有不包括继承方法名称：  " + m);

        }

        //************************************我是华丽的分割线******************************************************


        //================通过反射获取构造器                  =====================================

        //all the public constructors of the class represented by this Class object.
        Constructor[] constructors = c.getConstructors();
        System.out.println("本类中public构造器的个数：  " + constructors.length);
        for (Constructor constructor : constructors) {
            System.out.println("本类中public构造器:  " + constructor);
        }

        //all the constructors declared by the class represented by this   Class  object. These are public, protected,
        // default  (package) access, and private constructors
        Constructor[] constructors1 = c.getDeclaredConstructors();
        System.out.println("本类中all构造器的个数：  " + constructors1.length);

        System.out.println(constructors1.length);
        for (Constructor constructor : constructors1) {
            System.out.println("本类中all构造器:  " + constructor);
        }

        //************************************我是华丽的分割线******************************************************


    }

}
