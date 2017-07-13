package com.zhuoyue.payroll.serviceImpl.transaction;

import com.zhuoyue.payroll.service.AddEmployeeTransaction;
import com.zhuoyue.payroll.service.PaymentClassification;
import com.zhuoyue.payroll.service.PaymentSchedule;
import com.zhuoyue.payroll.serviceImpl.classification.HourlyClassification;
import com.zhuoyue.payroll.serviceImpl.schedule.WeeklySchedule;

/**
 * @author xyy
 * @create 2017-07-13 17:29
 **/
public class AddHourlyEmployeeTransaction extends AddEmployeeTransaction {

    private double rate;

    AddHourlyEmployeeTransaction(String name, String address, double hourlyRate) {
        super(name, address);
        this.rate = hourlyRate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new HourlyClassification(rate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }
}
