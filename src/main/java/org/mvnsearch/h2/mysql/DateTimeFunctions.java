package org.mvnsearch.h2.mysql;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * date time functions for mysql
 *
 * @author linux_china
 */
public class DateTimeFunctions {
    public static LocalDateTime ZERO_START_TIME = LocalDateTime.of(0, 1, 1, 0, 0, 0);
    public static LocalDateTime UNIX_START_TIME = LocalDateTime.of(1970, 1, 1, 0, 0, 0);

    /**
     * function for UNIX_TIMESTAMP
     *
     * @return current time millis
     */
    public static Long unixTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * function for UNIX_TIMESTAMP
     *
     * @return current time millis
     */
    public static Long unixTimestamp(String text) throws Exception {
        return DateUtils.parseDate(text, "YYYY-MM-DD HH:MM:SS", "YYYY-MM-DD").getTime();
    }

    public static Date fromUnixTime(Long unixTime) {
        return new Date(unixTime * 1000);
    }

    public static Date addDate(String dateText, Integer days) throws Exception {
        Date date = DateUtils.parseDate(dateText, "yyyy-MM-dd");
        return new Date(date.getTime() + days * 24 * 60 * 60 * 1000);
    }

    public static Date addTime(String dateText, String timeText) throws Exception {
        Date date = DateUtils.parseDate(dateText, "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.S", "HH:mm:ss", "HH:mm:ss.S", "dd HH:mm:ss", "dd HH:mm:ss.S");
        Date time = DateUtils.parseDate(timeText, "HH:mm:ss", "HH:mm:ss.S", "dd HH:mm:ss", "dd HH:mm:ss.S");
        return new Date(date.getTime() + time.getTime());
    }

    public static String date(String text) throws Exception {
        Date date = DateUtils.parseDate(text, "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.SSS");
        return DateFormatUtils.format(date, "yyyy-MM-dd");
    }

    public static String utcTimestamp() {
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("UTC"));
    }

    public static String utcDate() {
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd", TimeZone.getTimeZone("UTC"));
    }

    public static String utcTime() {
        return DateFormatUtils.format(new Date(), "HH:mm:ss", TimeZone.getTimeZone("UTC"));
    }

    public static Date fromDays(Integer days) {
        return java.sql.Date.valueOf(ZERO_START_TIME.plusDays(days).toLocalDate());
    }

    public static Long toDays(String timeText) throws Exception {
        LocalDate startDate = ZERO_START_TIME.toLocalDate();
        Date date = DateUtils.parseDate(timeText, "yyyy-MM-dd", "yy-MM-dd");
        LocalDate endDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return (ChronoUnit.DAYS.between(startDate, endDate));
    }

    public static Long toSeconds(String timeText) throws Exception {
        Date date = DateUtils.parseDate(timeText, "yyyy-MM-dd", "yy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yy-MM-dd HH:mm:ss");
        long days = ChronoUnit.DAYS.between(ZERO_START_TIME.toLocalDate(), UNIX_START_TIME.toLocalDate());
        return date.getTime() / 1000 + days * 24 * 60 * 60;
    }

    public static Long timeToSeconds(String timeText) throws Exception {
        Date date = DateUtils.parseDate("1970-01-01 " + timeText + " UTC", "yyyy-MM-dd HH:mm:ss z");
        return date.getTime() / 1000;
    }

    public static String secondsToTime(Integer totalSeconds) {
        int seconds = totalSeconds % 60;
        int minutes = totalSeconds / 60 % 60;
        int hours = totalSeconds / (3600) % 24;
        return padNumber(hours) + ":" + padNumber(minutes) + ":" + padNumber(seconds);
    }

    public static String time(String timeText) throws Exception {
        Date date = DateUtils.parseDate(timeText, "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.SSS");
        return DateFormatUtils.format(date, " HH:mm:ss");
    }

    public static String dateFormat(String timeText, String mysqlPattern) throws Exception {
        Date date = DateUtils.parseDate(timeText, "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss");
        String javaPattern = mysqlPattern;
        for (Map.Entry<String, String> entry : patternMapper().entrySet()) {
            javaPattern = javaPattern.replace(entry.getKey(), entry.getValue());
        }
        return DateFormatUtils.format(date, javaPattern);
    }

    public static String lastDay(String dateText) throws Exception {
        Date date = DateUtils.parseDate(dateText, "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.SSS");
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate lastDay = localDate.with(TemporalAdjusters.lastDayOfMonth());
        return lastDay.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static Date now() {
        return new Date();
    }

    public static Date makeDate(Integer year, Integer days) {
        LocalDateTime start = LocalDateTime.of(year, 1, 1, 0, 0, 0);
        LocalDateTime end = start.plusDays(days - 1);
        return java.sql.Date.valueOf(end.toLocalDate());
    }

    public static String makeTime(Integer hours, Integer minutes, Integer seconds) {
        return padNumber(hours) + ":" + padNumber(minutes) + ":" + padNumber(seconds);
    }

    public static Integer sleep(Integer seconds) throws Exception {
        Thread.sleep(seconds * 1000);
        return 0;
    }

    public static String strToDate(String dateStr, String mysqlPattern) throws Exception {
        String javaPattern = mysqlPattern;
        for (Map.Entry<String, String> entry : patternMapper().entrySet()) {
            javaPattern = javaPattern.replace(entry.getKey(), entry.getValue());
        }
        Date date = DateUtils.parseDate(dateStr, javaPattern);
        if (mysqlPattern.contains("%Y")) {
            return DateFormatUtils.format(date, "yyyy-MM-dd");
        } else {
            return DateFormatUtils.format(date, "HH:mm:ss");
        }
    }

    private static String padNumber(Integer number) {
        if (number < 10) return "0" + number;
        return String.valueOf(number);
    }

    private static Map<String, String> patternMapper() {
        //todo %H:%i:%s
        Map<String, String> convert = new HashMap<>();
        convert.put("%H", "HH");
        convert.put("%i", "mm");
        convert.put("%s", "ss");
        convert.put("%W", "E");
        convert.put("%Y", "yyyy");
        convert.put("%m", "M");
        convert.put("%M", "M");
        convert.put("%d", "dd");
        return convert;
    }
}
