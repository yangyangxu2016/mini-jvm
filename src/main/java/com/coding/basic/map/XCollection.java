package com.coding.basic.map;

/**
 * @author 14258
 */
public interface XCollection<E> {

    boolean add(E e);
    boolean addAll(XCollection<? extends E> c);
    boolean remove(Object o);
    boolean removeAll(XCollection<?> c);
    int size();
    void clear();
    boolean isEmpty();
    boolean contains(Object o);
    boolean containsAll(XCollection<?> c);
    boolean retainAll(XCollection<?> c);
    Object[] toArray();
    <T> T[] toArray(T[] a);

    XIterator<E> iterator();
    @Override
    boolean equals(Object o);
    @Override
    int hashCode();
}
