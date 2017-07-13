package com.zhuoyue.payroll.domain;

import com.zhuoyue.payroll.serviceImpl.classification.CommissionedClassification;
import com.zhuoyue.payroll.serviceImpl.classification.HourlyClassification;
import com.zhuoyue.payroll.serviceImpl.paymethod.HoldMethod;
import com.zhuoyue.payroll.serviceImpl.schedule.BiweeklySchedule;
import com.zhuoyue.payroll.serviceImpl.schedule.MonthlySchedule;
import com.zhuoyue.payroll.serviceImpl.schedule.WeeklySchedule;

import java.util.List;

/**
 * @author xyy
 * @create 2017-07-13 17:08
 **/
public class PayrollService {

    public List<Employee> getAllEmployees() {
        return null;
    }

    public void savePaycheck(Paycheck pc) {

    }


    /**
     * 增加小时工
     *
     * @return
     */
    public Employee addHourlyEmployee(String name, String address, double hourlyRate) {
        Employee e = new Employee(name, address);
        e.setClassification(new HourlyClassification(hourlyRate));
        e.setSchedule(new WeeklySchedule());
        e.setPaymentMethod(new HoldMethod());
        return e;
    }

    /**
     * 增加月薪员工
     *
     * @param name
     * @param address
     * @param salary
     * @return
     */
    public Employee addSalariedEmployee(String name, String address, double salary) {
        Employee e = new Employee(name, address);
        e.setClassification(new HourlyClassification(salary));
        e.setSchedule(new MonthlySchedule());
        e.setPaymentMethod(new HoldMethod());
        return e;
    }


    public Employee addComissionedEmployee(String name, String address, double salary, double saleRate) {
        Employee e = new Employee(name, address);
        e.setClassification(new CommissionedClassification(salary, saleRate));
        e.setSchedule(new BiweeklySchedule());
        e.setPaymentMethod(new HoldMethod());
        //...  保存到数据库
        return e;
    }


}
