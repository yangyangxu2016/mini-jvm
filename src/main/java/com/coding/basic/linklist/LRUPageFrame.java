package com.coding.basic.linklist;

/**
 * 最近最少使用
 *  直接使用链表维护了
 *
 * @author xyy
 * @create 2017-06-19 14:03
 **/
public class LRUPageFrame {

    private boolean isEmpty(){
        return (first == null) && (last == null);
    }
    private static class Node {
        Node prev;
        Node next;
        int pageNum;

        Node() {
        }
    }

    private int capacity;
    private int currentSize;
    private Node first;
    private Node last;


    public LRUPageFrame(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
    }

    /**
     * 获取缓存中的对象
     *
     * @param pageNum
     */
    public void access(int pageNum) {
        Node node = find(pageNum);

        if (node != null) {
            moveExistingNodeToHead(node);
        } else {
            node = new Node();
            node.pageNum = pageNum;

            if (currentSize >= capacity) {
                removeLast();
            }
            addNewNodeToHead(node);
        }
    }

    private void moveExistingNodeToHead(Node node) {

        if (node == first) {
            return;
        } else if (node == last) {
            Node prevNode = node.prev;
            prevNode.next = null;
            last.prev = null;
            last = prevNode;
        } else {
            Node prevNode = node.prev;
            prevNode.next = node.next;

            Node nextNode = node.next;
            nextNode.prev = prevNode;
        }

        node.prev = null;
        node.next = first;
        first.prev = node;
        first = node;
    }

    private void addNewNodeToHead(Node node) {

        if (isEmpty()) {
            node.prev = null;
            node.next = null;
            first = node;
            last = node;
        } else {
            node.prev = null;
            node.next = first;
            first.prev = node;
            first = node;
        }
        this.currentSize++;
    }

    private void removeLast() {

        Node prev = last.prev;
        prev.next = null;
        last.prev = null;
        last = prev;
        this.currentSize--;
    }

    private Node find(int data) {
        Node node = first;
        while (node != null) {
            if (node.pageNum == data) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public String toString(){
        StringBuilder buffer = new StringBuilder();
        Node node = first;
        while(node != null){
            buffer.append(node.pageNum);

            node = node.next;
            if(node != null){
                buffer.append(",");
            }
        }
        return buffer.toString();
    }

}
