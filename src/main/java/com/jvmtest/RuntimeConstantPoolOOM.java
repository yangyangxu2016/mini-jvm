package com.jvmtest;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * 运行时常量池溢出导致的内存溢出异常
 *
 * @author xyy
 * @create 2017-08-15 8:56
 **/
public class RuntimeConstantPoolOOM {

    //        -------------------  -XX:PermSize=10M -XX:MaxPermSize=10M  --------不能使用JDK1.7----------------------------------------------

//    public static void main(String[] args) {

//        List<String> list = new ArrayList<String>();
//        int i = 0;
//        while (true) {
//            list.add(String.valueOf(i++).intern());
//        }

//    }

    //        -------------------------------------------------------------------------


    //        ------------------------XX:PermSize=10M -XX:MaxPermSize=10M  -----------------------------------------


    public static void main(String[] args) {

        String str1 = new StringBuffer("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
//true
        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
//false
        String str3 = new StringBuffer("ja1").append("va").toString();
        System.out.println(str3.intern() == str3);
//true
    }

    //        -------------------------------------------------------------------------

}


