package com.zhuoyue.payroll.serviceImpl.classification;

import com.zhuoyue.payroll.domain.Paycheck;
import com.zhuoyue.payroll.domain.TimeCard;
import com.zhuoyue.payroll.service.PaymentClassification;
import com.zhuoyue.payroll.util.DateUtil;

import java.util.Date;
import java.util.Map;

/**
 * @author xyy
 * @create 2017-07-12 11:47
 **/
public class HourlyClassification implements PaymentClassification {

    private double rate;
    private Map<Date, TimeCard> timeCards;

    public HourlyClassification(double hourRate) {
        this.rate = hourRate;
    }

    public void addTimeCard(TimeCard tc) {
        timeCards.put(tc.getDate(), tc);
    }

    public double calculatePay(Paycheck pc) {
        double totalPay = 0;
        for (TimeCard tc : timeCards.values()) {
            if (DateUtil.between(tc.getDate(), pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate())) {
                totalPay += calculatePayForTimeCard(tc);
            }
        }
        return totalPay;
    }


    /**
     * 根据小时数
     * 计算加班与不加班
     */
    private double calculatePayForTimeCard(TimeCard tc) {
        int hours = tc.getHours();

        if (hours > 8) {
            return 8 * rate + (hours - 8) * rate * 1.5;
        } else {
            return 8 * rate;
        }

    }
}
