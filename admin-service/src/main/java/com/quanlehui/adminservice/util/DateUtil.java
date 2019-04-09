package com.quanlehui.adminservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yezi
 * @date 2019/2/1 11:25
 */
public class DateUtil {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date formatDate(Date date) {
        String dateStr = simpleDateFormat.format(date);
        try {
            return simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期格式化为当天的yyyy-MM-dd 23:59:59
     *
     * @param date
     * @return
     */
    public static Date formatDate24H(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String endDate = dateFormat.format(date);
        try {
            dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
            return dateFormat.parse(endDate + " 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 日期格式化为当天的yyyy-MM-dd 00:00:00
     *
     * @param date
     * @return
     */
    public static Date formatStartDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String endDate = dateFormat.format(date);
        try {
            dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
            return dateFormat.parse(endDate + " 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
