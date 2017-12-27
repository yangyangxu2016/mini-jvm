package com.coding.basic.map;


public interface XMap<K, V> {


    int size();

    boolean isEmpty();

    boolean isContainsKey(Object key);

    boolean isContainsValue(Object value);

    V get(Object key);

    V put(K key, V value);

    V remove(Object key);

    void putAll(XMap<? extends K, ? extends V> m);

    V clear();




    boolean equals(Object o);



    int hashCode();


    interface XEntry<K, V> {

        K getKey();

        V getValue();

        V setValue(V value);

        boolean equals(Object o);


        int hashCode();
    }


}
