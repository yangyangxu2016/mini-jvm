package com.zhuoyue.payroll.serviceImpl.affiliation;

import com.zhuoyue.payroll.domain.Paycheck;
import com.zhuoyue.payroll.service.Affiliation;

/**
 * @author xyy
 * @create 2017-07-13 9:52
 **/
public class NonAffiliation implements Affiliation {
    public double calculateDeductions(Paycheck pc) {
        return 0.0d;
    }
}
