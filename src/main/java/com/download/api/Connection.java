package com.download.api;

import java.io.IOException;

/**
 * 连接
 *
 * @author xyy
 * @create 2017-06-07 10:06
 **/
public interface Connection {
    /**
     * @Author xuyangyang
     * @Describe  给定开始和结束位置， 读取数据， 返回值是字节数组
     * @Date 2017/6/7
     * @Params 
     * @Return 
     */
    byte[] read(int startPos, int endPos) throws IOException ;


    /**
     * @Author xuyangyang
     * @Describe 得到数据内容的长度
     * @Date 2017/6/7
     * @Params
     * @Return
     */
    int getContentLength();


    /**
     * @Author xuyangyang
     * @Describe  关闭连接
     * @Date 2017/6/7
     * @Params
     * @Return
     */
    void close();
}
