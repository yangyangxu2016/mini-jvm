package com.zhuoyue.payroll.service;

import java.util.Date;

/**
 * @author xyy
 *         支付计划
 * @create 2017-07-12 11:44
 **/
public interface PaymentSchedule {

    /**
     * 是否支付日期
     */
    public boolean isPayDate(Date date);

    /**
     * 获取支付开始日期
     */
    public Date getPayPeriodStartDate(Date payPeriodEndDate);

}
