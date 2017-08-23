package com.org.litejunit.v1;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * 组合模式
 * @author xyy
 * @create 2017-08-22 16:31
 **/
public class TestSuite  extends Assert implements  Test{

    private List<Test> tests = new ArrayList<>(10);
    private String name;

    public TestSuite() {

    }

    public TestSuite(final Class<?> theClass) {
        this.name = theClass.getName();
        Constructor<?> constructor = null;
        try {
            constructor = getConstrucror(theClass);
        } catch (NoSuchMethodException e) {
            addTest(warning("Class "+theClass.getName()+" has no public constructor TestCase(String name)"));
            return;
        }

        if (!Modifier.isPublic(theClass.getModifiers())) {
            addTest(warning("Class "+theClass.getName()+" is not public"));
            return;
        }

        Vector<String> names = new Vector<>();
        Method[] methods = theClass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            addTestMethod(methods[i], names, constructor);
        }

        if (tests.size() == 0) {
            addTest(warning("No tests found in "+theClass.getName()));
        }

    }

    private void addTestMethod(Method m, Vector<String> names, Constructor<?> constructor) {

        String name = m.getName();
        if (names.contains(name)) {
            return;
        }
        if (isPublicTestMethod(m)) {
            names.addElement(name);
            Object[] args = new Object[]{name};

                try {
                    addTest((Test) constructor.newInstance(args));
                } catch (InstantiationException e) {
                    addTest(warning("Cannot instantiate test case: " + name + " (" + exceptionToString(e) + ")"));
                } catch (InvocationTargetException e) {
                    addTest(warning("Exception in constructor: " + name + " (" + exceptionToString(e.getTargetException()) + ")"));
                } catch (IllegalAccessException e) {
                    addTest(warning("Cannot access test case: " + name + " (" + exceptionToString(e) + ")"));
                }
        }else {
            if (isTestMethod(m))
                addTest(warning("Test method isn't public: "+m.getName()));
        }
    }

    private boolean isTestMethod(Method m) {
        String name = m.getName();
        Class<?>[] paramters = m.getParameterTypes();
        Class<?> returnType = m.getReturnType();
        return paramters.length == 0 && name.startsWith("test") && returnType.equals(Void.TYPE);
    }

    private boolean isPublicTestMethod(Method m) {
        return isTestMethod(m) && Modifier.isPublic(m.getModifiers());

    }

    private Constructor<?> getConstrucror(Class<?> theClass) throws NoSuchMethodException {
        Class<?> args = String.class;
        return theClass.getConstructor(args);
    }


    public void addTest(Test test) {
        tests.add(test);
    }

    @Override
    public int countTestCases() {
        int count = 0;
        for (Iterator<Test> e = tests();e.hasNext();) {
            Test test = e.next();
            count = count + test.countTestCases();
        }
        return count;
    }

    @Override
    public void run(TestResult result) {
        for (Iterator<Test> e = tests();e.hasNext();) {
            if (result.shouldStop()) {
                break;
            }
            Test test = (Test) e.next();
            test.run(result);
        }




    }
    public Iterator<Test> tests() {
        return tests.iterator();
    }

    private Test warning(final String message) {
        return new TestCase("warning") {
            public void doRun() {
                fail(message);
            }
        };
    }
    private String exceptionToString(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        return stringWriter.toString();

    }
}
