package com.coding.basic.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 递归和非递归实现对二叉树的遍历
 *
 * @author xyy
 * @create 2017-05-09 19:39
 **/
public class BinaryTreeUtil {


    /**
     * 用递归的方式实现对二叉树的前序遍历， 需要通过BinaryTreeUtilTest测试
     *
     * @param root
     * @return
     */
    public static <T> List<T> preOrderVisit(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<T>();

//        BinaryTreeNode<T> currentNode = root;
//        BinaryTreeNode<T> par;
//        if (currentNode.getData() == null) {
//            return null;
//        } else {
//            result.add(currentNode.getData());
//            if (currentNode.getLeft() != null) {
//                currentNode = currentNode.getLeft();
//                preOrderVisit(currentNode);
//            }
//            if (currentNode.getRight() != null) {
//                currentNode = currentNode.getRight();
//                preOrderVisit(currentNode);
//            }
//        }

        if (root != null) {
            result.add(root.getData());
            result.add((T) preOrderVisit(root.getLeft()));
            result.add((T) preOrderVisit(root.getRight()));
        }

        return result;
    }

    /**
     * 用递归的方式实现对二叉树的中遍历
     *
     * @param root
     * @return
     */
    public static <T> List<T> inOrderVisit(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<T>();

        return result;
    }

    /**
     * 用递归的方式实现对二叉树的后遍历
     *
     * @param root
     * @return
     */
    public static <T> List<T> postOrderVisit(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<T>();

        return result;
    }

    /**
     * 用非递归的方式实现对二叉树的前序遍历
     *
     * @param root
     * @return
     */
    public static <T> List<T> preOrderWithoutRecursion(BinaryTreeNode<T> root) {

        List<T> result = new ArrayList<T>();

        return result;
    }

    /**
     * 用非递归的方式实现对二叉树的中序遍历
     *
     * @param root
     * @return
     */
    public static <T> List<T> inOrderWithoutRecursion(BinaryTreeNode<T> root) {

        List<T> result = new ArrayList<T>();

        return result;
    }

}


