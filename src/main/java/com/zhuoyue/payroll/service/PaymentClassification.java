package com.zhuoyue.payroll.service;

import com.zhuoyue.payroll.domain.Paycheck;


/**
 * @author xyy
 *         员工分类
 * @create 2017-07-12 11:44
 **/
public interface PaymentClassification {

    public double calculatePay(Paycheck pc);
}
