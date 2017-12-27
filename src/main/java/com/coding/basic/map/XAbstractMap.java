package com.coding.basic.map;


/**
 * @author 14258
 */
public abstract class XAbstractMap<K, V> implements XMap<K, V> {

    protected XAbstractMap() {

    }

    public abstract XSet<XEntry<K, V>> entryXSet();

    transient volatile XSet<K>        keySet = null;
    transient volatile XCollection<V> values = null;

    public int size() {
        return entryXSet().size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public V get(Object key) {
        XIterator<XEntry<K, V>> i = entryXSet().iterator();
        if (key == null) {
            while (i.hasNext()) {
                XEntry<K, V> e = i.next();
                //
                if (e.getKey() == null) {
                    return e.getValue();
                }
            }
        } else {
            while (i.hasNext()) {
                XEntry<K, V> e = i.next();
                //
                if (key.equals(e.getKey())) {
                    return e.getValue();
                }
            }
        }
        return null;
    }

    public V put(K key, V value) {
        throw new UnsupportedOperationException();
    }


    public V remove(Object key) {
        XIterator<XEntry<K, V>> i = entryXSet().iterator();

        XEntry<K, V> correctEntry = null;
        if (key == null) {
            while (correctEntry == null && i.hasNext()) {
                XEntry<K, V> e = i.next();
                if (e.getKey() == null) {
                    correctEntry = e;
                }
            }
        } else {
            while (correctEntry == null && i.hasNext()) {
                XEntry<K, V> e = i.next();
                if (key.equals(e.getKey())) {
                    correctEntry = e;
                }
            }
        }

        V oldValue = null;
        if (correctEntry != null) {
            oldValue = correctEntry.getValue();
            i.remove();
        }
        return oldValue;

    }

    public void clear() {
        entryXSet().clear();
    }


}
