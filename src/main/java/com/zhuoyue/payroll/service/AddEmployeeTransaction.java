package com.zhuoyue.payroll.service;

import com.zhuoyue.payroll.domain.Employee;
import com.zhuoyue.payroll.serviceImpl.paymethod.HoldMethod;

/**
 * @author xyy
 * @create 2017-07-13 17:29
 **/
public abstract class AddEmployeeTransaction {

    private String name;
    private String address;

    public AddEmployeeTransaction(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public abstract PaymentClassification getClassification();

    public abstract PaymentSchedule getSchedule();


    public void execute() {
        PaymentClassification pc = getClassification();
        PaymentSchedule ps = getSchedule();
        PaymentMethod pm = new HoldMethod();
        Employee e = new Employee(name, address);
        e.setClassification(pc);
        e.setSchedule(ps);
        e.setPaymentMethod(pm);
        //保存到数据库, 略
    }


}
