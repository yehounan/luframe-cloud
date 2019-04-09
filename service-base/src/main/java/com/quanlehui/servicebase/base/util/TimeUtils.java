package com.quanlehui.servicebase.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Desc    : 基于 JDK 8 time包的时间工具类
 * @date    : 2018-01-16
 *
 * @author : yxy
 */
public class TimeUtils {

    /**
     * 获取默认时间格式: yyyy-MM-dd HH:mm:ss
     */
    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = TimeFormat.LONG_DATE_PATTERN_LINE.formatter;

    private TimeUtils() {
        // no construct function
    }

    /**
     * String 转时间
     *
     * @param timeStr
     * @return
     */
    public static LocalDateTime parseTime(String timeStr) {
        return LocalDateTime.parse(timeStr, DEFAULT_DATETIME_FORMATTER);
    }

    /**
     * String 转时间
     *
     * @param timeStr
     * @param format  时间格式
     * @return
     */
    public static LocalDateTime parseTime(String timeStr, TimeFormat format) {
        return LocalDateTime.parse(timeStr, format.formatter);
    }

    /**
     * 时间转 String
     *
     * @param time
     * @return
     */
    public static String parseTime(LocalDateTime time) {
        return DEFAULT_DATETIME_FORMATTER.format(time);
    }

    /**
     * 时间转 String
     *
     * @param time
     * @param format 时间格式
     * @return
     */
    public static String parseTime(LocalDateTime time, TimeFormat format) {
        return format.formatter.format(time);
    }

    /**
     * LocalDateTime 转 Date
     * @param time
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime time){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = time.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentDatetime() {
        return DEFAULT_DATETIME_FORMATTER.format(LocalDateTime.now());
    }

    /**
     * 获取当前时间
     *
     * @param format 时间格式
     * @return
     */
    public static String getCurrentDatetime(TimeFormat format) {
        return format.formatter.format(LocalDateTime.now());
    }

    /**
     * @date转换为LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant,zoneId);
    }

    /**
     * 毫秒数转换为LocalDateTime
     * @param millis
     * @return
     */
    public static LocalDateTime millisToLocalDateTime(long millis){
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis),ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转换为毫秒数
     * @param localDateTime
     * @return
     */
    public static long localDateTimeToMillis(LocalDateTime localDateTime){
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 获取某个时间点当天开始时间
     * @param millis
     * @return
     */
    public static Date getStartTime(long millis) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTimeInMillis(millis);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 获取某个时间点当天结束时间
     * @param millis
     * @return
     */
    public static Date getEndTime(long millis) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTimeInMillis(millis);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * 传入日期与当前日期的间隔
     * @param date 日期
     * @return 间隔字符串,间隔毫秒如果小于1分钟返回0-59秒,如果小于1小时返回0-59分,如果小于1天返回1-23时,如果大于1天返回多少天
     */
    public static String intervalDateFromNow(Date date){
        long sourceMillis = date.toInstant().toEpochMilli();
        long nowMillis = System.currentTimeMillis();
        long intervalMillis = nowMillis - sourceMillis;
        String result = "";
        if (intervalMillis / 1000 < 60) {
            result = intervalMillis / 1000 + "秒";
        } else if (intervalMillis / 1000 / 60 < 60) {
            result = intervalMillis / 1000 / 60 + "分";
        } else if (intervalMillis / 1000 / 60 / 60 < 24) {
            result = intervalMillis / 1000 / 60 / 60 + "时";
        } else if (intervalMillis / 1000 / 60 / 60 > 24) {
            result = intervalMillis / 1000 / 60 / 60 / 24 + "天";
        } else {
            result = "格式错误";
        }
        return result;
    }

    /**
     * 将Date类型的时间转换为String类型的时间
     * @param date
     * @param format
     * @return
     */
    public static String convertDateToString(Date date,TimeFormat format){
        return TimeUtils.parseTime(TimeUtils.dateToLocalDateTime(date),format);
    }

    /**
     * 将String类型的时间转换为Date类型的时间
     * @param timeStr
     * @param format
     * @return
     */
    public static Date convertStringToDate(String timeStr,TimeFormat format){
       return TimeUtils.localDateTimeToDate(TimeUtils.parseTime(timeStr,format));
    }

    /**
     * 将毫秒数转换为String
     * @param millis
     * @param format
     * @return
     */
    public static String convertMillisToString(long millis,TimeFormat format){
        LocalDateTime localDateTime = TimeUtils.millisToLocalDateTime(millis);
        return TimeUtils.parseTime(localDateTime, format);
    }

    /**
     * 将String转换为毫秒数
     * @param timeStr
     * @param format
     * @return
     */
    public static long convertStringToMillis(String timeStr,TimeFormat format){
        LocalDateTime localDateTime = TimeUtils.parseTime(timeStr,format);
        return TimeUtils.localDateTimeToMillis(localDateTime);
    }

    /**
     * 时间格式
     */
    public enum TimeFormat {

        /**
         * 短时间格式 只保留年月
         */
        SHORT_YEAR_MONTH_PATTERN_LINE("yyyy-MM"),
        SHORT_YEAR_MONTH_PATTERN_SLASH("yyyy/MM"),
        SHORT_YEAR_MONTH_PATTERN_DOUBLE_SLASH("yyyy\\MM"),
        SHORT_YEAR_MONTH_PATTERN_NONE("yyyyMM"),

        /**
         * 短时间格式
         */
        SHORT_DATE_PATTERN_LINE("yyyy-MM-dd"),
        SHORT_DATE_PATTERN_SLASH("yyyy/MM/dd"),
        SHORT_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd"),
        SHORT_DATE_PATTERN_NONE("yyyyMMdd"),

        /**
         * 长时间格式
         */
        LONG_DATE_PATTERN_LINE("yyyy-MM-dd HH:mm:ss"),
        LONG_DATE_PATTERN_SLASH("yyyy/MM/dd HH:mm:ss"),
        LONG_DATE_PATTERN_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss"),
        LONG_DATE_PATTERN_NONE("yyyyMMdd HH:mm:ss"),

        /**
         * 长时间格式 带毫秒
         */
        LONG_DATE_PATTERN_WITH_MILSEC_LINE("yyyy-MM-dd HH:mm:ss.SSS"),
        LONG_DATE_PATTERN_WITH_MILSEC_SLASH("yyyy/MM/dd HH:mm:ss.SSS"),
        LONG_DATE_PATTERN_WITH_MILSEC_DOUBLE_SLASH("yyyy\\MM\\dd HH:mm:ss.SSS"),
        LONG_DATE_PATTERN_WITH_MILSEC_NONE("yyyyMMdd HH:mm:ss.SSS"),
        LONG_DATE_PATTERN_WITH_MINUTE("yyyyMMddHHmm");

        private transient DateTimeFormatter formatter;

        TimeFormat(String pattern) {
            formatter = DateTimeFormatter.ofPattern(pattern);
        }
    }



//    public static void main(String[] args) throws ParseException {
//        String now = TimeUtils.getCurrentDatetime();
//        System.out.println(now);
//        LocalDateTime time = millisToLocalDateTime(System.currentTimeMillis());
//        System.out.println(parseTime(time));
//        String r = intervalDateFromNow(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-01-31 17:29:00"));
//        System.out.println(r);
//
//        String time2 = "2018-12";
//        LocalDateTime now2 = LocalDateTime.now();
//        String nowYearMonth = TimeUtils.parseTime(now2, TimeFormat.SHORT_YEAR_MONTH_PATTERN_LINE);
//        System.out.println(nowYearMonth);
//        if(nowYearMonth.compareTo(time2)==0){
//            System.out.println("年月为当前月");
//        }else {
//            System.out.println("年月为过去月或未来月");
//        }
//
//        //将LocalDateTime转换为毫秒数
//        long millis = TimeUtils.localDateTimeToMillis(LocalDateTime.now());
//        System.out.println(millis);
//
//        //将Date转换为String
//        System.out.println(TimeUtils.convertDateToString(new Date(), TimeFormat.SHORT_DATE_PATTERN_LINE));
//
//        //将String转换为Date
//        Date date = TimeUtils.convertStringToDate("2018-03-27 14:52:57", TimeFormat.LONG_DATE_PATTERN_LINE);
//        System.out.println(date.toString());
//
//        //将毫秒数转化为String
//        System.out.println(TimeUtils.convertMillisToString(System.currentTimeMillis(), TimeFormat.LONG_DATE_PATTERN_LINE));
//
//        //将String转化为毫秒数
//        long millis2 = TimeUtils.convertStringToMillis("2018-03-27 14:52:57", TimeFormat.LONG_DATE_PATTERN_LINE);
//        System.out.println(millis2);
//    }
}
