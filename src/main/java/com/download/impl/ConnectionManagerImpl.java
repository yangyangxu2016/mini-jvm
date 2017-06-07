package com.download.impl;

import com.download.api.Connection;
import com.download.api.ConnectionException;
import com.download.api.ConnectionManager;

/**
 * @author xyy
 * @create 2017-06-07 10:22
 **/
public class ConnectionManagerImpl implements ConnectionManager {

    @Override
    public Connection open(String url) throws ConnectionException {
        return new ConnectionImpl(url);
    }
}
