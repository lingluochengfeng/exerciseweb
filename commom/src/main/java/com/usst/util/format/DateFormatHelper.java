package com.usst.util.format;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化的工具
 */
public class DateFormatHelper {
    private DateFormatHelper(){}

    private final static String FORMAT_STR = "yyyy-MM-dd HH:mm:ss";

    public static String long2str(long time){
        Date date = new Date(time);

        DateFormat df = new SimpleDateFormat(FORMAT_STR);

        return df.format(date);
    }

    public static long str2long(String str) throws ParseException {
        DateFormat df = new SimpleDateFormat(FORMAT_STR);
        return df.parse(str).getTime();
    }
}
