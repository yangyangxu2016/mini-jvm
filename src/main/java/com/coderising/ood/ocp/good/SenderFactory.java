package com.coderising.ood.ocp.good;

import java.util.NoSuchElementException;

/**
 * @author xyy
 * @create 2017-06-22 10:48
 **/
public class SenderFactory {



    public static Sender createSendType(String type) {

        if (type.equals("SMS_LOG")) {
            return new SmsSender();
        } else if (type.equals("EMAIL_LOG")) {
            return new EmailSender();
        } else if (type.equals("PRINT_LOG")) {
            return new PrintSender();
        } else {
            throw new NoSuchElementException("请选择 或 ");
        }
    }
}
