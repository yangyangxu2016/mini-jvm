package com.coding.basic.array;

import com.coding.basic.XIterator;
import com.coding.basic.XList;

import java.util.Objects;


/**
 * @author xyy
 * @create 2017-06-13 14:08
 **/
public class XArrayList implements XList {

	private int size;
	private transient Object[] elementData = new Object[10];


	public boolean add(Object o) {
		ensureCapacity(size + 1);
		elementData[size] = o;
		size++;
		return true;
	}


	public void add(int index, Object o) {
		if (index > size || index < 0) {
			throw new ArrayIndexOutOfBoundsException("数组下标越界异常");
		}
		ensureCapacity(size + 1);
		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = o;
		size++;
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
		elementData[size - 1] = null;
		size--;
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
		elementData[size - 1] = null;
		size--;
		return oldValue;
	}


	public Object get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("数据下标越界异常");
		}
		return elementData[index];
	}


	public void clear() {
		for (int i = 0; i < size; i++) {
			elementData[i] = null;
		}
		size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (Objects.equals(o, elementData[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @Author xuyangyang
	 * @Describe 确保数组容量大小
	 * @Date 2017/6/14
	 * @Params a
	 * @Return a
	 */
	private void ensureCapacity(int minCapacity) {
		int oldCapacity = elementData.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = (oldCapacity * 3) / 2 + 1;
			if (minCapacity > newCapacity) {
				newCapacity = minCapacity;
			}
			Object[] newArray = new Object[newCapacity];
			System.arraycopy(elementData, 0, newArray, 0, newCapacity);
			elementData = newArray;
//			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}

	public XIterator iterator() {
		return new ArrayListIterator();
	}

	/**
	 * 内部类，和类的实例做绑定
	 */
	private class ArrayListIterator implements XIterator {

		private int position;

		@Override
		public boolean hasNext() {
			return position < size();
		}

		@Override
		public Object next() {
			if (hasNext()) {
				return get(position++);
			}
			return null;
		}

	}


}
