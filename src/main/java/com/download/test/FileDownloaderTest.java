package com.download.test;

import com.download.FileDownloader;
import com.download.api.ConnectionManager;
import com.download.api.DownloadListener;
import com.download.impl.ConnectionManagerImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试多线程下载
 * @author xyy
 * @create 2017-06-07 11:32
 **/
public class FileDownloaderTest {

    boolean downloadFinished = false;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testDownload() {

        String url = "http://dzs.qisuu.com/txt/%E5%A4%AA%E4%B8%8A%E7%AB%A0.txt";
        FileDownloader downloader = new FileDownloader(url, "D://太上章.txt");

        ConnectionManager cm = new ConnectionManagerImpl();
        downloader.setConnectionManager(cm);

        downloader.setListener(new DownloadListener() {
            @Override
            public void notifyFinished() {
                downloadFinished = true;
            }
        });

        downloader.execute();
        // 等待多线程下载程序执行完毕
        while (!downloadFinished) {
            try {
                System.out.println("还没有下载完成，休眠五秒");
                //休眠5秒
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("下载完成！");

    }


}
