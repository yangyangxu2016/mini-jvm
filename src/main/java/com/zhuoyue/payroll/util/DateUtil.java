package com.zhuoyue.payroll.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xyy
 * @create 2017-07-13 9:59
 **/
public class DateUtil {


    /**
     * 字符串转日期格式
     */
    public static Date parseDate(String txtDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(txtDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static long getDaysBetween(Date d1, Date d2) {
        return (d1.getTime() - d2.getTime()) / (24 * 60 * 60 * 1000);

    }

    public static Date add(Date d, int days) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public static boolean isFriday(Date d) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(Calendar.DAY_OF_WEEK);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

        return calendar.get(Calendar.DAY_OF_WEEK) == 5;
    }

    public static boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE) == calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static Date getFirstDay(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        int day = calendar.get(Calendar.DATE);
        calendar.add(Calendar.DATE, -day + 1);

        return calendar.getTime();
    }

    public static boolean between(Date d, Date date1, Date date2) {
        return d.after(date1) && d.before(date1);
    }


    public static void main(String[] args) {
        getFirstDay(parseDate("2017-07-13"));
    }
}
