package com.download.api;

/**
 * 连接管理
 *
 * @author xyy
 * @create 2017-06-07 10:05
 **/
public interface ConnectionManager {

    
    /**
     * @Author xuyangyang
     * @Describe 给定一个url , 打开一个连接
     * @Date 2017/6/7
     * @Params 
     * @Return 
     */
    Connection open(String url) throws ConnectionException;




}
