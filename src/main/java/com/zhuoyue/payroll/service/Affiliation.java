package com.zhuoyue.payroll.service;

import com.zhuoyue.payroll.domain.Paycheck;

/**
 * @author xyy
 * @create 2017-07-12 11:41
 **/
public interface Affiliation {

    double calculateDeductions(Paycheck pc);

}
