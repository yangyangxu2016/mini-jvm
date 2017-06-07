package com.download.impl;

import com.download.api.Connection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

/**
 * @author xyy
 * @create 2017-06-07 10:23
 **/
public class ConnectionImpl implements Connection {

    URL url;
    static final int BUFFER_SIZE = 1024;


    public ConnectionImpl(String _url) {
        try {
            url = new URL(_url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public byte[] read(int startPos, int endPos) throws IOException {

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestProperty("Range", "bytes=" + startPos + "-" + endPos);

        InputStream in = httpURLConnection.getInputStream();

        byte[] bytes = new byte[BUFFER_SIZE];

        int totalLen = endPos - startPos + 1;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        while (baos.size() < totalLen) {
            int len = in.read(bytes);
            if (len < 0) {
                break;
            }
            baos.write(bytes, 0, len);
        }

        if (baos.size() > totalLen) {
            byte[] data = baos.toByteArray();
            return Arrays.copyOf(data, totalLen);
        }

        return baos.toByteArray();
    }

    @Override
    public int getContentLength() {
        URLConnection con;
        try {
            con = url.openConnection();

            return con.getContentLength();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void close() {

    }
}
