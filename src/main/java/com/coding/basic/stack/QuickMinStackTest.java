package com.coding.basic.stack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * jvm第6次数据结构作业
 * 测试类
 *
 * @author xyy
 * @create 2017-05-22 13:49
 **/
public class QuickMinStackTest {

    static QuickMinStack stack = new QuickMinStack();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test() {
        stack.push(5);
        Assert.assertEquals(5, stack.findMin());
        stack.push(6);
        Assert.assertEquals(5, stack.findMin());
        stack.push(4);
        Assert.assertEquals(4, stack.findMin());
        stack.push(4);
        Assert.assertEquals(4, stack.findMin());

        stack.pop();
        Assert.assertEquals(4, stack.findMin());
        stack.pop();
        Assert.assertEquals(5, stack.findMin());
        stack.pop();
        Assert.assertEquals(5, stack.findMin());
    }


}
