package com.example.demo.base.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Where.LIU
 * @link https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
 * @link https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
 * @since 2022/4/11
 */
public class DateTimeUtils {
    public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String ISO8601_DATE = "yyyy-MM-dd";
    public static final String ISO8601_TIME = "HH:mm:ss";
    public static final String ISO8601_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String ISO8601_DATE_TIME_ZONE = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

    public static LocalDate dateToLocalDate(Date date) {
        return LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static LocalDate dateToLocalDate(Date date, ZoneId zoneId) {
        return LocalDate.ofInstant(date.toInstant(), zoneId);
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static LocalDateTime dateToLocalDateTime(Date date, ZoneId zoneId) {
        return LocalDateTime.ofInstant(date.toInstant(), zoneId);
    }

    public static ZonedDateTime dateToZonedDateTime(Date date) {
        return ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static ZonedDateTime dateToZonedDateTime(Date date, ZoneId zoneId) {
        return ZonedDateTime.ofInstant(date.toInstant(), zoneId);
    }

    public static Date localDateToDate(LocalDate localDate) {
        return null;
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime, ZoneId zoneId) {
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }

    public static Date startOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date endOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static String datetime(Date date) {
        return DateTimeFormatter.ofPattern(DATE_TIME)
                .format(ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));
    }
}
