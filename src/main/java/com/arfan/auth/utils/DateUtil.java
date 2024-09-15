package com.arfan.auth.utils;

import com.arfan.auth.enums.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DateUtil {
    public static Date parseDateTime2(String date) throws ParseException {
        if (Objects.isNull(date) || date.trim().length() < 1) {
            return null;
        }
        var outputDateFormat = new SimpleDateFormat(Constants.FORMAT_DATE_YYYYMMDD_6);
        return outputDateFormat.parse(date.trim());
    }

    public static String formatDateYD6(Date date) {
        SimpleDateFormat outputDateFormat = new SimpleDateFormat(Constants.FORMAT_DATE_YYYYMMDD_6);
        return outputDateFormat.format(date);
    }
}
