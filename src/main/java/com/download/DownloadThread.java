package com.download;

import com.download.api.Connection;

import java.io.RandomAccessFile;
import java.util.concurrent.CyclicBarrier;

/**
 * 利用线程在文件的指定位置写入指定数据
 *
 * @author xyy
 * @create 2017-06-07 13:52
 **/
public class DownloadThread extends Thread {

    Connection conn;
    int startPos;
    int endPos;
    CyclicBarrier barrier;
    String localFile;

    public DownloadThread(Connection conn, int startPos, int endPos, String localFile, CyclicBarrier barrier) {
        this.conn = conn;
        this.startPos = startPos;
        this.endPos = endPos;
        this.localFile = localFile;
        this.barrier = barrier;
    }


    public void run() {
        System.out.println("开始现在文件,从" + this.startPos + "到" + this.endPos);

        RandomAccessFile raf = null;
        try {
            byte[] bytes = conn.read(startPos, endPos);
            raf = new RandomAccessFile(localFile, "rw");
            raf.seek(startPos);
            raf.write(bytes);
            raf.close();
            conn.close();
            //线程在这里等待，直到所有线程都到达barrier。
            barrier.await();//等待别的线程完成
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
