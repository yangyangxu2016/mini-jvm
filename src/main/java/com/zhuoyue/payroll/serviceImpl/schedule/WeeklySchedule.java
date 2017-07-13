package com.zhuoyue.payroll.serviceImpl.schedule;

import com.zhuoyue.payroll.service.PaymentSchedule;
import com.zhuoyue.payroll.util.DateUtil;

import java.util.Date;

/**
 * @author xyy
 * @create 2017-07-13 16:38
 **/
public class WeeklySchedule implements PaymentSchedule {


    public boolean isPayDate(Date date) {
        return DateUtil.isFriday(date);
    }

    public Date getPayPeriodStartDate(Date payPeriodEndDate) {
        return DateUtil.add(payPeriodEndDate, -6);
    }

}
