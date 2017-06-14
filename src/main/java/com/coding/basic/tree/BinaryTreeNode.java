package com.coding.basic.tree;

/**
 * 二叉树的实现插入和搜索
 *
 * @author xyy
 * @create 2017-06-14 17:11
 **/
public class BinaryTreeNode<T extends Comparable> {

    private T data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    private int size;


    public T getData() {
        return data;
    }

    public BinaryTreeNode<T> setData(T data) {
        this.data = data;
        return this;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public BinaryTreeNode<T> setLeft(BinaryTreeNode<T> left) {
        this.left = left;
        return this;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public BinaryTreeNode<T> setRight(BinaryTreeNode<T> right) {
        this.right = right;
        return this;
    }


    public BinaryTreeNode<T> insert(T data) {
        if (this.data == null) {
            this.data = data;
            return this;
        }
        int comparaResult = this.data.compareTo(data);
        if (comparaResult > 0) {
            if (this.left == null) {
                this.left = new BinaryTreeNode();
                this.left.data = data;
                return this.left;
            } else {
                return this.left.insert(data);
            }
        } else if (comparaResult < 0) {
            if (this.right == null) {
                this.right = new BinaryTreeNode();
                this.right.data = data;
                return this.right;
            } else {
                return this.right.insert(data);
            }
        } else {
            return this;
        }
    }


    public BinaryTreeNode<T> search(T data) {
        if (this.data == null) {
            return null;
        }
        int comparaResult = this.data.compareTo(data);
        if (comparaResult > 0) {
            if (this.left == null) {
                return null;
            } else {
                return this.left.search(data);
            }
        } else if (comparaResult < 0) {
            if (this.right == null) {
                return null;
            } else {
                return this.right.search(data);
            }
        } else {
            return this;
        }

    }
}





