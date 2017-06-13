package com.coding.basic.array;

import com.coding.basic.Iterator;
import com.coding.basic.List;

import java.util.Arrays;


/**
 * @author xyy
 * @create 2017-06-13 14:08
 **/
public class ArrayList implements List{

	private transient Object[] elementData = new Object[10];

	private int size;


	public boolean add(Object o) {
		ensureCapacity(size + 1);
		elementData[size++] = o;
		return true;
	}


	public void add(int index, Object o) {
		if (index > size || index < 0) {
			throw new ArrayIndexOutOfBoundsException("数组下标越界异常");
		}
		ensureCapacity(size + 1);
		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = o;
	}


	public boolean remove(Object o) {
		if (o == null) {
			for (int index = 0; index < size; index++) {
				if (elementData[index] == null) {
					fastRemove(index);
					return true;
				}
			}
		} else {
			for (int index = 0; index < size; index++) {
				if (o.equals(elementData[index])) {
					fastRemove(index);
					return true;
				}
			}
		}
		return false;
	}

	private void fastRemove(int index) {
		int numSize = size - index - 1;
		if (numSize > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, numSize);
		}
		elementData[--size] = null;
	}


	public Object remove(int index) {
		if (index >= size || index < 0) {
			throw new ArrayIndexOutOfBoundsException("数组下标越界异常");
		}
		Object oldValue = elementData[index];
		int numSize = size - index - 1;
		if (numSize > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, numSize);
		}
		elementData[--size] = null;
		return oldValue;
	}

	public int size() {
		return size;
	}

	public Object get(int index) {
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException("数据下标越界异常");
		}
		return elementData[index];
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

	public Iterator iterator() {
		return null;
	}


}
