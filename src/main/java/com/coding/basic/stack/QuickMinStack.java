package com.coding.basic.stack;

import java.util.Stack;

/**
 * jvm第6次数据结构作业
 * 设计一个栈，支持栈的push和pop操作，以及第三种操作findMin, 它返回改数据结构中的最小元素,finMin操作最坏的情形下时间复杂度应该是O(1) ，
 * 简单来讲，操作一次就可以得到最小值
 *
 * @author xyy
 * @create 2017-05-22 11:33
 **/
public class QuickMinStack {


    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();

    public void push(int data) {
        stack1.push(data);
        if (stack2.isEmpty()) {
            stack2.push(data);
        } else {
            if (stack2.peek() >= data) {
                stack2.push(data);
            }
        }
    }

    public int pop() {
        if (stack1.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int temp = stack1.pop();
        if (temp == stack2.peek()) {
            stack2.pop();
        }
        return temp;
    }

    public int findMin() {
        if (stack2.isEmpty()) {
            throw new RuntimeException("stack2栈为空");
        }
        return stack2.peek();
    }
}
