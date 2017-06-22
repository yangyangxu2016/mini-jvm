package com.coderising.ood.ocp.good;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xyy
 * @create 2017-06-22 10:20
 **/
public class RawLogWithDataFormatter implements Formatter{


    @Override
    public String format(String message) {
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY年MM月dd日 HH时mm分ss秒");
        return formatter.format(new Date())+message;
    }
}
