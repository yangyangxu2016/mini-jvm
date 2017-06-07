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

    //定义两个栈,一个存数据,一个维护大小顺序
    Stack<Integer> normalStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();


    public void push(int data) {
        normalStack.push(data);

        if (minStack.isEmpty()) {
            minStack.push(data);
        } else {
            if (minStack.peek() >= data) {
                minStack.push(data);
            }
        }
    }


    public int pop() {
        if (normalStack.isEmpty()) {
            throw new RuntimeException("栈为空!");
        }
        int value = normalStack.pop();
        if (value == minStack.peek()) {
            minStack.pop();
        }
        return value;
    }


    public int findMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("栈为空!");
        }
        return minStack.peek();
    }
















}
