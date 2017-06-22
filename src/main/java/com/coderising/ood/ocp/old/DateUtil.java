package com.coderising.ood.ocp.old;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getCurrentDateAsString() {

        SimpleDateFormat formatter = new SimpleDateFormat("YYYY年MM月dd日 HH时mm分ss秒");
        return formatter.format(new Date());
    }

}
