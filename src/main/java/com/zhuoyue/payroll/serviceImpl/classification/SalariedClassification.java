package com.zhuoyue.payroll.serviceImpl.classification;

import com.zhuoyue.payroll.domain.Paycheck;
import com.zhuoyue.payroll.service.PaymentClassification;

/**
 * @author xyy
 * @create 2017-07-12 11:47
 **/
public class SalariedClassification implements PaymentClassification {

    private double salary;

    public SalariedClassification(double salary) {
        this.salary = salary;
    }

    public double calculatePay(Paycheck pc) {
        return salary;
    }

}
