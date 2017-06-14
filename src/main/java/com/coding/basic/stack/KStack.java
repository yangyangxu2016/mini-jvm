package com.coding.basic.stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * 使用数组实现Stack
 *
 * @author xyy
 * @create 2017-06-14 15:48
 **/
public class KStack {

    private int size;
    private Object[] elementData = {};


    public Object push(Object o) {
        ensureCapacity(size + 1);
        elementData[size] = o;
        size++;
        return o;
    }

    public Object pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Object oldValue = elementData[size - 1];
        elementData[size - 1] = null;
        size--;
        return oldValue;

    }

    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return elementData[size - 1];
    }

    public boolean empty() {
        return size == 0;
    }


    public int size() {
        return size;
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            if (minCapacity > newCapacity) {
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

}
