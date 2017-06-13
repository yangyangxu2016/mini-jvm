package com.coding.basic;

/**
 * @author xyy
 * @create 2017-06-13 14:43
 **/
public interface List {
	public boolean add(Object o);

	public void add(int index, Object o);

	public Object get(int index);

	public Object remove(int index);

	public int size();
}
