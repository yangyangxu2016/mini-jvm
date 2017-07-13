package com.zhuoyue.payroll.serviceImpl.schedule;

import com.zhuoyue.payroll.service.PaymentSchedule;
import com.zhuoyue.payroll.util.DateUtil;

import java.util.Date;

/**
 * @author xyy
 * @create 2017-07-13 10:31
 **/
public class MonthlySchedule implements PaymentSchedule {
    public boolean isPayDate(Date date) {
        return DateUtil.isLastDayOfMonth(date);
    }

    public Date getPayPeriodStartDate(Date payPeriodEndDate) {
        return DateUtil.getFirstDay(payPeriodEndDate);
    }

}
