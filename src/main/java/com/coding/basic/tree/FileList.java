package com.coding.basic.tree;


import java.io.File;

/**
 * 给定一个目录，递归的列出下面所有的子目录和文件
 *
 * @author xyy
 * @create 2017-05-09 19:21
 **/
public class FileList {


    public static void main(String[] args) {
        String fileName = "F:\\Shadowsocks-3.4.3";
        File file = new File(fileName);
        list(file);
    }

    public static void list(File file) {

        if (file != null) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (int i = 0; i < files.length; i++) {
                        if (files[i].isDirectory()) {
                            System.out.println(files[i].getPath());
                        }
                        list(files[i]);
                    }
                }
            } else {
                System.out.println(file);
            }
        }

    }


}
