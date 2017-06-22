package com.coderising.ood.ocp.good;

/**
 * @author xyy
 * @create 2017-06-22 10:19
 **/
public class RawLogFormatter implements Formatter {
    @Override
    public String format(String message) {
        return "Raw:  "+ message;
    }
}
