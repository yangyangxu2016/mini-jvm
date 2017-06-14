package com.coding.basic.queue;

import java.util.LinkedList;

/**
 * Queue的 enQueue和deQueue实现
 *
 * @author xyy
 * @create 2017-06-14 16:53
 **/
public class KQueue {

    private LinkedList myList;
    private int size;

    public KQueue() {
        this.myList = new LinkedList();
    }

    public void enQueue(Object o) {
        myList.addLast(o);
    }

    public Object deQueue() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return myList.removeLast();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


}
