package com.coding.basic.map;


public interface XSet<E> extends XCollection<E> {
    int size();

    boolean isEmpty();

    boolean contains(Object o);

    XIterator<E> iterator();

    Object[] toArray();

    <T> T[] toArray(T[] a);

    boolean add(E e);

    boolean remove(Object o);

    boolean containsAll(XCollection<?> c);

    boolean addAll(XCollection<? extends E> c);

    boolean retainAll(XCollection<?> c);

    boolean removeAll(XCollection<?> c);

    void clear();

    boolean equals(Object o);

    int hashCode();


}
