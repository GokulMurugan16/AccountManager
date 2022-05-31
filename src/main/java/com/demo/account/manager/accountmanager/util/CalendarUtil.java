package com.demo.account.manager.accountmanager.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarUtil {

    public static final String DEFAULT_DATE_TIME_FORMAT_SECONDS = "dd/MM/yyyy HH:mm:ss";

    public static Date getParsedDateTime(String date) throws ParseException {
        return getParsedDate(date, DEFAULT_DATE_TIME_FORMAT_SECONDS);
    }

    public static Date getParsedDate(String date, String dateFormat) throws ParseException {
        Date parsedDate;
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        parsedDate = format.parse(date);
        return parsedDate;
    }
}
