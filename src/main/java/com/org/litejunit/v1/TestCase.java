package com.org.litejunit.v1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 设计模式之模板方法
 * @author xyy
 * @create 2017-08-22 16:09
 **/
public abstract class TestCase extends Assert implements Test {


    private String name;

    public TestCase(String name) {
        this.name = name;
    }

    /**
     * 统计测试个数
     * @return
     */
    @Override
    public int countTestCases() {
        return 1;
    }

    @Override
    public void run(TestResult tr) {
        tr.run(this);
    }


    protected  void runTest ()throws Throwable{
        Method runMethod = null;
        try {
            runMethod = getClass().getMethod(name, null);
        } catch (NoSuchMethodException e) {
            fail("Method \""+name+"\" not found");
        }
        if (!Modifier.isPublic(runMethod.getModifiers())) {
            fail("Method \""+name+"\" should be public");
        }

        try {
            runMethod.invoke(this, new Class[0]);
        } catch (InvocationTargetException e) {
            e.fillInStackTrace();
            throw e.getTargetException();
        } catch (IllegalAccessException e) {
            e.fillInStackTrace();
            throw e;
        }

    }



    /**
     * 模板方法
     * @throws Throwable
     */
    public void doRun() throws Throwable {
        setUp();
        try {
            runTest();
        }finally {
            tearDown();
        }

    }
    /**
     * 执行之前运行
     */
    protected void setUp() {

    }

    /**
     * 执行之后运行
     */
    protected void tearDown() {

    }

























}
