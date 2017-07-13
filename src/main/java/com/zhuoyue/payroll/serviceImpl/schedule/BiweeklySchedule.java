package com.zhuoyue.payroll.serviceImpl.schedule;

import com.zhuoyue.payroll.service.PaymentSchedule;
import com.zhuoyue.payroll.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xyy
 * @create 2017-07-12 15:39
 **/
public class BiweeklySchedule implements PaymentSchedule {

    Date firstPayableFriday = DateUtil.parseDate("2017-6-2");

    public static void main(String[] args) throws Exception {
        BiweeklySchedule schedule = new BiweeklySchedule();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse("2017-07-15");

        System.out.println(schedule.isPayDate(d));

        System.out.println(DateUtil.isFriday(d));
        System.out.println(schedule.getPayPeriodStartDate(d));
    }

    public boolean isPayDate(Date date) {

        long interval = DateUtil.getDaysBetween(firstPayableFriday, date);
        return interval % 14 == 0;
    }

    public Date getPayPeriodStartDate(Date payPeriodEndDate) {
        return DateUtil.add(payPeriodEndDate, -13);
    }

}
