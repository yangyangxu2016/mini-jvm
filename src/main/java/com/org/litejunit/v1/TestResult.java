package com.org.litejunit.v1;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xyy
 * @create 2017-08-22 16:09
 **/
public class TestResult {


    protected List<TestFailure> failures;
    protected List<TestFailure> errors;

    protected int testCount;
    private boolean stop;


    public TestResult() {
        failures= new ArrayList<>();
        errors= new ArrayList<>();

        testCount= 0;
        stop= false;
    }
    public void run(TestCase test) {

        startTest(test);
        try {
            test.doRun();
        } catch (AssertionFailedError e) {
            addFailure(test, e);
        } catch (Throwable e) {
            addError(test, e);
        }
        endTest(test);

    }


    private void startTest(TestCase test) {
        int count = test.countTestCases();
        testCount = count;
    }

    private void endTest(TestCase test) {
    }


    private void addError(Test test, Throwable t) {
        errors.add(new TestFailure(test, t));
    }

    private void addFailure(Test test, Throwable t) {
        failures.add(new TestFailure(test, t));
        System.out.println("失败");
    }














    public  int runCount() {
        return testCount;
    }


    public  boolean shouldStop() {
        return stop;
    }

    public  void stop() {
        stop= true;
    }

    public  int errorCount() {
        return errors.size();
    }

    public  Iterator errors() {
        return errors.iterator();
    }

    public  int failureCount() {
        return failures.size();
    }

    public Iterator<TestFailure> failures() {
        return failures.iterator();
    }

    public  boolean wasSuccessful() {
        return this.failureCount() == 0 && this.errorCount() == 0;
    }
}
