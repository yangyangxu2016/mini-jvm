package com.zhuoyue.payroll.domain;

import com.zhuoyue.payroll.service.Affiliation;
import com.zhuoyue.payroll.service.PaymentClassification;
import com.zhuoyue.payroll.service.PaymentMethod;
import com.zhuoyue.payroll.service.PaymentSchedule;

import java.util.Date;

/**
 * Created by 14258 on 2017/7/6.
 */
public class Employee {

    private String id;
    private String name;
    private String address;
    private Affiliation affiliation;  //从属关系

    private PaymentClassification classification;  //分类
    private PaymentSchedule schedule;
    private PaymentMethod paymentMethod;


    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * 是否支付日
     */
    public boolean isPayDay(Date d) {
        return this.schedule.isPayDate(d);
    }

    /**
     * 获得支付开始日期
     */
    public Date getPayPeriodStartDate(Date d) {
        return this.schedule.getPayPeriodStartDate(d);
    }


    /**
     * 支付检查,计算工资
     */
    public void payDay(Paycheck pc) {
        double grossPay = classification.calculatePay(pc);
        double deductions = affiliation.calculateDeductions(pc);
        double netPay = grossPay - deductions;
        pc.setGrossPay(grossPay);
        pc.setDeductions(deductions);
        pc.setNetPay(netPay);
        //支付方式
        paymentMethod.pay(pc);
    }

    public Employee setClassification(PaymentClassification classification) {
        this.classification = classification;
        return this;
    }

    public Employee setSchedule(PaymentSchedule schedule) {
        this.schedule = schedule;
        return this;
    }

    public Employee setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }
}
