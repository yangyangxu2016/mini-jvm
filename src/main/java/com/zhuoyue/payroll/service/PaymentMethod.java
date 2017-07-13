package com.zhuoyue.payroll.service;

import com.zhuoyue.payroll.domain.Paycheck;

/**
 * @author xyy
 *         怎样支付-1:存在财务处使用时支取,2:支票,3:银行转账
 * @create 2017-07-12 11:44
 **/
public interface PaymentMethod {


    void pay(Paycheck pc);
}
