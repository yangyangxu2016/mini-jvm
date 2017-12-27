package com.coding.basic.map;

public interface XIterator<E> {

    boolean hasNext();

    E next();

    void remove();
}
