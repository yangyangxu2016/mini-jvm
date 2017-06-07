package com.download;

import com.download.api.Connection;
import com.download.api.ConnectionManager;
import com.download.api.DownloadListener;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.CyclicBarrier;

/**
 * @author xyy
 * @create 2017-06-07 11:35
 **/
public class FileDownloader {

    private String url;
    private String localFile;

    ConnectionManager cm;
    DownloadListener listener;//持有一个下载监听的引用

    private static final int DOWNLOAD_TRHEAD_NUM = 3;

    public FileDownloader(String _url, String localFile) {
        this.url = _url;
        this.localFile = localFile;
    }


    public void setConnectionManager(ConnectionManager connectionManager) {
        this.cm = connectionManager;
    }

    public void setListener(DownloadListener listener) {
        this.listener = listener;
    }


    /**
     * @Author xuyangyang
     * @Describe 调用进行下载
     * @Date 2017/6/7
     * @Params
     * @Return
     */
    /*
     在这里实现你的代码， 注意： 需要用多线程实现下载
     这个类依赖于其他几个接口, 你需要写这几个接口的实现代码
     (1) ConnectionManager , 可以打开一个连接，通过Connection可以读取其中的一段（用startPos, endPos来指定）
     (2) DownloadListener, 由于是多线程下载， 调用这个类的客户端不知道什么时候结束，所以你需要实现当所有
         线程都执行完以后， 调用listener的notifiedFinished方法， 这样客户端就能收到通知。
     具体的实现思路：
     1. 需要调用ConnectionManager的open方法打开连接， 然后通过Connection.getContentLength方法获得文件的长度
     2. 至少启动3个线程下载，  注意每个线程需要先调用ConnectionManager的open方法
     然后调用read方法， read方法中有读取文件的开始位置和结束位置的参数， 返回值是byte[]数组
     3. 把byte数组写入到文件中
     4. 所有的线程都下载完成以后， 需要调用listener的notifiedFinished方法

     下面的代码是示例代码， 也就是说只有一个线程， 你需要改造成多线程的。
     */
    public void execute() {

        CyclicBarrier barrier = new CyclicBarrier(DOWNLOAD_TRHEAD_NUM, new Runnable() {
            @Override
            public void run() {
                listener.notifyFinished();
            }
        });


        Connection conn = null;

        try {
            conn = cm.open(this.url);
            int fileLength = conn.getContentLength();
            //创建一个本地缓存文件, 占位
            createPlaceHolderFile(this.localFile, fileLength);
            //建立一个二维数组, 为每个线程分配大小
            int[][] ranges = allocateDownloadRange(DOWNLOAD_TRHEAD_NUM, fileLength);

            for (int i = 0; i < DOWNLOAD_TRHEAD_NUM; i++) {
                DownloadThread thread = new DownloadThread(
                        cm.open(this.url),
                        ranges[i][0],
                        ranges[i][1],
                        localFile,
                        barrier);
                thread.start();

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }


    /**
     * @Author xuyangyang
     * @Describe 建立一个二维数组, 为每个线程分配大小
     * @Date 2017/6/7
     * @Params
     * @Return
     */
    private int[][] allocateDownloadRange(int threadNum, int fileLength) {
        int[][] ranges = new int[threadNum][2];

        int eachThreadSize = fileLength / threadNum;//每个线程需要下载的文件大小
        int left = fileLength % threadNum;//剩余的文件大小,增加到--最后一个线程

        for (int i = 0; i < threadNum; i++) {
            int startPos = i * eachThreadSize;
            int endPos = (i + 1) * eachThreadSize - 1;
            if (i == (threadNum - 1)) {
                endPos += left;
            }
            ranges[i][0] = startPos;
            ranges[i][1] = endPos;
        }
        return ranges;
    }


    /**
     * @Author xuyangyang
     * @Describe 创建一个本地缓存文件, 占位
     * @Date 2017/6/7
     * @Params
     * @Return
     */
    private void createPlaceHolderFile(String fileName, int fileLength) {

        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(fileName, "rw");
            for (int i = 0; i < fileLength; i++) {
                raf.write(0);//占位
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
