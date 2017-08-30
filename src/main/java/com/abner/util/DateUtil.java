package com.abner.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public final class DateUtil {

    /**
     * 默认的日期格式
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_YYYYMM = "yyyy-MM";
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_FORMAT_YYYYMMDDHH = "yyyyMMddHH";
    public static final String DATE_FORMAT_YYYYMMDD_HHMM = "yyyy-MM-dd HH:mm";
    public static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_HHMMSS_SSS = "HHmmssSSS";
    public static final String DATE_FORMAT_YYMMDDHH = "yyMMddHH";
    public static final String DATE_FORMAT_YYMMDD = "yyMMdd";
    public static final String DATE_FORMAT_YYYYMMDD_HHMMSS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DATE_FORMAT_YYYYMMDD_HH_MM_SS = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String DATE_FORMAT_MM_dd_HH_mm = "MM月dd日 HH:mm";

    /**
     * 取得当前时间的数值串
     *
     * @return 当前时间的数值串
     */
    public static long getCurrentTimeMillis() {
        long currentTime = System.currentTimeMillis();
        return currentTime;
    }

    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String getCurrentDate() {
        return formatTime(getCurrentTimestamp(), DATE_FORMAT_YYYYMMDD_HHMMSS);
    }

    public static String formatTime(Timestamp target, String format) {
        if (target == null) {
            return "";
        }
        return new SimpleDateFormat(format).format(target);
    }

}
