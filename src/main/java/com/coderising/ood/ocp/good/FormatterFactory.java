package com.coderising.ood.ocp.good;

import java.util.NoSuchElementException;

/**
 * @author xyy
 * @create 2017-06-22 10:42
 **/
public class FormatterFactory {

    public static Formatter createFormatter(String type) {
        if (type.equals("RAW_LOG")) {
            return new RawLogFormatter();
        } else if (type.equals("RAW_LOG_WITH_DATE")) {
            return new RawLogWithDataFormatter();
        } else {
            throw new NoSuchElementException("请选择RAW_LOG或RAW_LOG_WITH_DATE");
        }
    }

}
