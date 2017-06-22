package com.coderising.ood.ocp.good;

/**
 * @author xyy
 * @create 2017-06-22 10:51
 **/
public class PrintSender implements Sender {


    @Override
    public void send(String msg) {
        System.out.println(msg);
    }
}
