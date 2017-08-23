package com.org.litejunit.v1;

/**
 * @author xyy
 * @create 2017-08-22 16:54
 **/
public class CalculatorTest  extends TestCase{


    public CalculatorTest(String name) {
        super(name);
    }

    Calculator calculator =null;


    public void setUp(){
        calculator = new Calculator();
    }
    public void tearDown(){
        calculator = null;
    }


    public void testAdd(){

        calculator.add(10);
        assertEquals(10,calculator.getResult());
    }
    public void testSubtract(){
        calculator.add(10);
        calculator.subtract(5);
        assertEquals(4,calculator.getResult());
    }

    public static void main(String[] args) {
        TestSuite ts = new TestSuite(CalculatorTest.class);
        TestResult tr = new TestResult();
        ts.run(tr);
        System.out.println(tr.wasSuccessful());
        for (TestFailure failure : tr.failures) {
            System.err.println(failure);
        }
    }

}
