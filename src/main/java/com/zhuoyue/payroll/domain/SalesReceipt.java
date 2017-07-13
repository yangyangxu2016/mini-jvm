package com.zhuoyue.payroll.domain;

import java.util.Date;

/**
 * @author xyy
 *         销售凭条-销售人员专用
 * @create 2017-07-13 16:45
 **/
public class SalesReceipt {

    private Date saleDate;
    private double amount;

    public Date getSaleDate() {
        return saleDate;
    }

    public double getAmount() {
        return amount;
    }
}
