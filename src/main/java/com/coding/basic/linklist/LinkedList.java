package com.coding.basic.linklist;

import com.coding.basic.List;

import java.util.NoSuchElementException;

public class LinkedList implements List {

	private transient int size = 0;

	private transient Node first;

	private transient Node last;

	public LinkedList() {

	}

	public boolean add(Object o) {
		linkLast(o);
		return false;
	}

	private void linkLast(Object o) {
		final Node l = last;
		final Node newNode = new Node(l, o, null);
		last = newNode;
		if (l == null)
			first = newNode;
		else
			l.next = newNode;
		size++;

	}

	public void add(int index, Object o) {
		if (index < 0 || index > size()) {
			throw new ArrayIndexOutOfBoundsException("数组下标越界异常");
		}

		if (index == size) {
			linkLast(o);
		} else {
			linkBefore(o, node(index));
		}

	}

	private void linkBefore(Object o, Node node) {
		final Node prev = node.prev;
		final Node newNode = new Node(prev, o, node);
		node.prev = newNode;
		if (prev == null) {
			first = newNode;
		} else {
			prev.next = newNode;
		}
		size++;
	}

	private Node node(int index) {
		if (index < (size >> 1)) {
			Node x = first;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}
			return x;
		} else {
			Node x = last;
			for (int i = size - 1; i > index; i--) {
				x = x.prev;
			}
			return x;
		}
	}

	public Object get(int index) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException("数组下标越界异常");
		}

		return node(index).item;
	}

	public Object remove(Object o) {
		return removeFirst();
	}

	private Object removeFirst() {
		final Node f = first;
		if (first == null) {
			throw new NoSuchElementException();
		}
		return unlinkFirst(f);
	}

	private Object unlinkFirst(Node f) {
		final Object elem = f.item;
		final Node next = f.next;
		f.item = null;
		f.next = null;

		first = next;
		if (next == null) {
			last = null;
		} else {
			next.prev = null;
		}
		size--;
		return elem;
	}

	public Object remove(int index) {
		if (index < 0 || index >= size) {
			throw new NoSuchElementException();
		}


		return unLink(node(index));
	}

	private Object unLink(Node node) {
		final Object elem = node.item;
		final Node next = node.next;
		final Node prev = node.prev;

		if (prev == null) {
			first = next;
		} else {
			prev.next = next;
			node.prev = null;
		}

		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
			node.next = next;
		}
		node.item = null;
		size--;

		return elem;
	}


	public int size() {
		return size;
	}


	private static class Node {
		Object item;
		Node prev;
		Node next;

		public Node(Node prev, Object item, Node next) {
			this.item = item;
			this.prev = prev;
			this.next = next;
		}
	}
}
