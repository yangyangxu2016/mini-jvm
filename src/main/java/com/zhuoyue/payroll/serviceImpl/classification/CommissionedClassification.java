package com.zhuoyue.payroll.serviceImpl.classification;

import com.zhuoyue.payroll.domain.Paycheck;
import com.zhuoyue.payroll.domain.SalesReceipt;
import com.zhuoyue.payroll.service.PaymentClassification;
import com.zhuoyue.payroll.util.DateUtil;

import java.util.Date;
import java.util.Map;

/**
 * @author xyy
 * @create 2017-07-12 11:47
 **/
public class CommissionedClassification implements PaymentClassification {

    double salary;
    double rate;

    Map<Date, SalesReceipt> receipts;

    public CommissionedClassification(double salary, double rate) {
        this.salary = salary;
        this.rate = rate;
    }

    public double calculatePay(Paycheck pc) {
        double comission = 0.0;
        for (SalesReceipt sr : receipts.values()) {
            if (DateUtil.between(sr.getSaleDate(), pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate())) {
                comission += sr.getAmount() * rate;
            }
        }
        return salary + comission;
    }


}
