package com.coding.basic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 第2次
 *
 * @author xyy
 * @create 2017-06-16 9:43
 **/
public class ArrayUtil {

    /**
     * 给定一个整形数组a , 对该数组的值进行置换
     * 例如： a = [7, 9 , 30, 3]  ,   置换后为 [3, 30, 9,7]
     * 如果     a = [7, 9, 30, 3, 4] , 置换后为 [4,3, 30 , 9,7]
     *
     * @param origin
     * @return
     */
    public int[] reverseArray(int[] origin) {
        int[] oldArray = origin;
        int newLength = oldArray.length;

        if (newLength == 0 || newLength == 1) {
            return oldArray;
        }

        int[] newArray = new int[newLength];

        for (int i = 0; i < newLength; i++) {
            newArray[i] = origin[newLength - 1 - i];
        }


        return newArray;

    }

    /**
     * 现在有如下的一个数组：   int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}
     * 要求将以上数组中值为0的项去掉，将不为0的值存入一个新的数组，生成的新数组为：
     * {1,3,4,5,6,6,5,4,7,6,7,5}
     *
     * @param oldArray
     * @return
     */

    public int[] removeZero(int[] oldArray) {

        int[] oldArr = oldArray;
        int newLength = oldArr.length;
        if (newLength == 0) {
            return oldArr;
        }
        int[] newArray = new int[newLength];
        int j = 0;
        for (int i = 0; i < newLength; i++) {
            if (oldArr[i] != 0) {
                newArray[j++] = oldArr[i];
            }
        }
        return Arrays.copyOf(newArray, j);
    }

    /**
     * 给定两个已经排序好的整形数组， a1和a2 ,  创建一个新的数组a3, 使得a3 包含a1和a2 的所有元素， 并且仍然是有序的
     * 例如 a1 = [3, 5, 7,8]   a2 = [4, 5, 6,7]    则 a3 为[3,4,5,6,7,8]    , 注意： 已经消除了重复
     *
     * @param array1
     * @param array2
     * @return
     */

    public int[] merge(int[] array1, int[] array2) {
        int newLength = array1.length + array2.length;
        if (newLength == 0) {
            return new int[0];
        }
        int[] newArray = new int[newLength];
        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            newArray[index++] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            newArray[index++] = array2[i];
        }

        //冒泡排序
        for (int i = 0; i < newArray.length - 1; i++) { //排序趟数(n-1)
            for (int j = 0; j < newArray.length - 1 - i; j++) {//每一趟排序多少次(N-i)
                if (newArray[j] > newArray[j + 1]) {
                    int temp = newArray[j];
                    newArray[j] = newArray[j + 1];
                    newArray[j + 1] = temp;
                }
            }
        }

        //数组去重1

/*
        int numSize = 0;
        int[] newArr = new int[newArray.length];
        for (int i = 0; i < newArray.length; i++) {
            if (i + 1 != newArray.length) {
                if (newArray[i] == newArray[i + 1]) {
                    continue;
                }
            }
            newArr[numSize++] = newArray[i];
        }
        newArr = Arrays.copyOf(newArr, numSize);
*/


        //数组去重2

        boolean[] b = new boolean[newArray.length];
        int count = newArray.length;
        for (int i = 0; i < newArray.length; i++) {
            for (int j = i + 1; j < newArray.length; j++) {
                if (newArray[i] == newArray[j] && b[i] == false) {
                    b[j] = true;
                    count--;
                }
            }
        }

        int[] newArr = new int[count];
        int j = 0;
        for (int i = 0; i < newArray.length; i++) {
            if (b[i] == false) {
                newArr[j++] = newArray[i];
            }
        }

        return newArr;
    }

    /**
     * 把一个已经存满数据的数组 oldArray的容量进行扩展， 扩展后的新数据大小为oldArray.length + size
     * 注意，老数组的元素在新数组中需要保持
     * 例如 oldArray = [2,3,6] , size = 3,则返回的新数组为
     * [2,3,6,0,0,0]
     *
     * @param oldArray
     * @param size
     * @return
     */
    public int[] grow(int[] oldArray, int size) {
        int oldLength = oldArray.length;
        if (size < 0) {
            throw new IndexOutOfBoundsException();
        }
        int newLength = oldLength + size;
        return Arrays.copyOf(oldArray, newLength);

    }

    /**
     * 斐波那契数列为：1，1，2，3，5，8，13，21......  ，给定一个最大值， 返回小于该值的数列
     * 例如， max = 15 , 则返回的数组应该为 [1，1，2，3，5，8，13]
     * max = 1, 则返回空数组 []
     * (维基百科-斐波那契数列)-https://zh.wikipedia.org/wiki/%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E6%95%B0%E5%88%97
     * (斐波那契数列—java实现)-http://www.cnblogs.com/xiaomingtx/p/5760973.html
     *
     * @param max
     * @return
     */
    public int[] fibonacci(int max) {
        int a = 1, b = 1, c = 2;
        int[] newArr = new int[max + 1];
        int index = 2;
        if (max == 1) {
            return Arrays.copyOf(newArr, 0);
        } else if (max <= 0) {
            throw new IllegalArgumentException();
        } else {
            newArr[0] = 1;
            newArr[1] = 1;
            do {
                c = a + b;
                a = b;
                b = c;
                newArr[index++] = c;
            } while (c < max);
        }
        if (newArr[index - 1] >= max) {
            return Arrays.copyOf(newArr, index - 1);
        }
        return Arrays.copyOf(newArr, index);
    }

    /**
     * 返回小于给定最大值max的所有素数数组
     * 例如max = 23, 返回的数组为[2,3,5,7,11,13,17,19]
     * 质数（Prime number），又称素数，指在大于1的自然数中，除了1和该数自身外，无法被其他自然数整除的数（也可定义为只有1与该数本身两个因数的数）。大于1的自然数若不是素数，则称之为合数。
     *
     * @param max
     * @return
     */
    public int[] getPrimes(int max) {
        int[] newArr = new int[max];
        int index = 0;
        for (int i = 0; i < max; i++) {
            if (isPrime(i)) {
                newArr[index++] = i;
            }
        }
        return Arrays.copyOf(newArr, index);
    }

    public boolean isPrime(int a) {
        if (a <= 1) {
            return false;
        }
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }


    public int[] getPerfectNumbersa(int max) {
        //保存每组的分解因子
        List list = new ArrayList();
        List pm = new ArrayList();
        int sum = 0;
        //除数
        for (int i = 2; i < max; i++) {
            //被除数
            sum=0;
            for (int j = 1; j < i / 2 + 1; j++) {
                if (i % j == 0) {
                    list.add(j);
                    sum += j;
                }
            }

            if (sum == i) {
                pm.add(i);
            }

            list.clear();
        }

        int[] pmaArr = new int[pm.size()];
        for (int i = 0; i < pm.size(); i++) {
            pmaArr[i] = (int) pm.get(i);
        }
        return pmaArr;
    }

    /**
     * 所谓“完数”， 是指这个数恰好等于它的因子之和，例如6=1+2+3
     * 给定一个最大值max， 返回一个数组， 数组中是小于max 的所有完数
     * (维基百科)-https://zh.wikipedia.org/wiki/%E5%AE%8C%E5%85%A8%E6%95%B0
     * 完全数，又称完美数或完备数，是一些特殊的自然数：它所有的真因子（即除了自身以外的约数）的和，恰好等于它本身，完全数不可能是楔形数。
     * 例如：第一个完全数是6，它有约数1、2、3、6，除去它本身6外，其余3个数相加，1+2+3＝6，恰好等于本身。
     * 第二个完全数是28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14＝28，也恰好等于本身。后面的数是496、8128。
     *
     * @param max
     * @return
     */
    public int[] getPerfectNumbers(int max) {

        int[] newArray = new int[max];
        int index=0;
        for (int i = 0; i < max; i++) {
            if (isPerfectNumber(i)) {
                newArray[index++] = i;
            }
        }

        return  Arrays.copyOf(newArray, index);
    }

    public   boolean isPerfectNumber(int a) {
        if (a < 6) {
            return false;
        }

        int sum =0;
        for (int i =1; i<a/2+1; i++) {
            if (a % i == 0) {
                sum += i;
            }
        }
        if (sum == a) {
            return true;
        }
        return false;
    }




    /**
     * 用seperator 把数组 array给连接起来
     * 例如array= [3,8,9], seperator = "-"
     * 则返回值为"3-8-9"
     *
     * @param array
     * @param
     * @return
     */
    public String join(int[] array, String seperator) {
        int oldLength = array.length;
        if (oldLength <1) {
            return "";
        }
        if (oldLength == 1) {
            return String.valueOf(array[0]);
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i <oldLength; i++) {
            if (i < oldLength-1) {
                buffer.append(array[i]);
                buffer.append(seperator);
            } else if (i == oldLength - 1) {
                buffer.append(array[i]);
            }
        }
        return buffer.toString();
    }
}
