package org.mvnsearch.h2.mysql;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * date time functions for mysql
 *
 * @author linux_china
 */
public class DateTimeFunctions {
  public static LocalDateTime ZERO_START_TIME = LocalDateTime.of(0, 1, 1, 0, 0, 0);
  public static LocalDateTime UNIX_START_TIME = LocalDateTime.of(1970, 1, 1, 0, 0, 0);
  public static ZoneOffset DEFAULT_ZONE_OFFSET = OffsetDateTime.now().getOffset();

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
  public static Long unixTimestamp(Timestamp timestamp) throws Exception {
    return timestamp.getTime();
  }

  public static LocalDateTime fromUnixTime(Long unixTime) {
    return LocalDateTime.ofEpochSecond(unixTime, 0, DEFAULT_ZONE_OFFSET);
  }

  public static Date addDate(Timestamp date, Integer days) throws Exception {
    return new Date(date.getTime() + days * 24 * 60 * 60 * 1000);
  }

  public static Date subDate(Timestamp date, Integer days) throws Exception {
    return new Date(date.getTime() - days * 24L * 60L * 60L * 1000L);
  }

  public static Date addTime(Timestamp date, String timeText) throws Exception {
    java.util.Date time = DateUtils.parseDate(timeText, "HH:mm:ss", "HH:mm:ss.S", "dd HH:mm:ss", "dd HH:mm:ss.S");
    return new Date(date.getTime() + time.getTime());
  }

  public static Date subTime(Timestamp date, String timeText) throws Exception {
    java.util.Date time = DateUtils.parseDate(timeText, "HH:mm:ss", "HH:mm:ss.S", "dd HH:mm:ss", "dd HH:mm:ss.S");
    return new Date(date.getTime() - time.getTime());
  }

  public static Date date(Timestamp date) throws Exception {
    return new Date(date.getTime());
  }

  public static LocalDateTime utcTimestamp() {
    return ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime();
  }

  public static LocalDate utcDate() {
    return ZonedDateTime.now(ZoneId.of("UTC")).toLocalDate();
  }

  public static LocalTime utcTime() {
    return ZonedDateTime.now(ZoneId.of("UTC")).toLocalTime();
  }

  public static Date sysDate() {
    return new Date(System.currentTimeMillis());
  }

  public static LocalDate fromDays(Integer days) {
    return ZERO_START_TIME.plusDays(days).toLocalDate();
  }

  public static Long toDays(Date date) throws Exception {
    LocalDate startDate = ZERO_START_TIME.toLocalDate();
    LocalDate endDate = date.toLocalDate();
    return (ChronoUnit.DAYS.between(startDate, endDate));
  }

  public static Long toSeconds(Timestamp date) throws Exception {
    long days = ChronoUnit.DAYS.between(ZERO_START_TIME.toLocalDate(), UNIX_START_TIME.toLocalDate());
    return date.getTime() / 1000 + days * 24 * 60 * 60;
  }

  public static Long timeToSeconds(Time time) throws Exception {
    return time.getTime() / 1000;
  }

  public static String secondsToTime(Integer totalSeconds) {
    long seconds = totalSeconds % 60;
    long minutes = totalSeconds / 60 % 60;
    long hours = totalSeconds / (3600) % 24;
    return padNumber(hours) + ":" + padNumber(minutes) + ":" + padNumber(seconds);
  }

  public static Time time(Timestamp date) throws Exception {
    return new Time(date.getTime());
  }

  public static String dateFormat(Timestamp date, String mysqlPattern) throws Exception {
    String javaPattern = mysqlPattern;
    for (Map.Entry<String, String> entry : mysqlToJavaDateFormat().entrySet()) {
      javaPattern = javaPattern.replace(entry.getKey(), entry.getValue());
    }
    return DateFormatUtils.format(date, javaPattern);
  }

  public static String timeFormat(Time time, String mysqlPattern) throws Exception {
    String javaPattern = mysqlPattern;
    for (Map.Entry<String, String> entry : mysqlToJavaDateFormat().entrySet()) {
      javaPattern = javaPattern.replace(entry.getKey(), entry.getValue());
    }
    return DateFormatUtils.format(time, javaPattern);
  }

  public static LocalDate lastDay(Timestamp dateTime) throws Exception {
    LocalDate localDate = dateTime.toLocalDateTime().toLocalDate();
    return localDate.with(TemporalAdjusters.lastDayOfMonth());
  }

  public static Date makeDate(Integer year, Integer days) {
    LocalDateTime start = LocalDateTime.of(year, 1, 1, 0, 0, 0);
    LocalDateTime end = start.plusDays(days - 1);
    return Date.valueOf(end.toLocalDate());
  }

  public static String makeTime(Integer hours, Integer minutes, Integer seconds) {
    return padNumber((long) hours) + ":" + padNumber((long) minutes) + ":" + padNumber((long) seconds);
  }

  public static Integer sleep(Integer seconds) throws Exception {
    Thread.sleep(seconds * 1000);
    return 0;
  }

  public static String strToDate(String dateStr, String mysqlPattern) throws Exception {
    String javaPattern = mysqlPattern;
    for (Map.Entry<String, String> entry : mysqlToJavaDateFormat().entrySet()) {
      javaPattern = javaPattern.replace(entry.getKey(), entry.getValue());
    }
    java.util.Date date = DateUtils.parseDate(dateStr, javaPattern);
    if (mysqlPattern.toLowerCase().contains("%y")) {
      return DateFormatUtils.format(date, "yyyy-MM-dd");
    } else {
      return DateFormatUtils.format(date, "HH:mm:ss");
    }
  }

  public static Integer yearWeek(Timestamp timestamp, Integer mode) throws Exception {
    LocalDate localDate = timestamp.toLocalDateTime().toLocalDate();
    int day = localDate.getDayOfWeek().getValue();
    if (day > 0) {
      localDate = localDate.minusDays(day);
    }
    int year = localDate.getYear();
    int offset = mode == 0 ? 1 : 0;
    int weekNumber = localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()) - offset;
    return year * 100 + weekNumber;
  }


  public static Integer yearWeek(Timestamp timestamp) throws Exception {
    return yearWeek(timestamp, 0);
  }

  public static Integer weekOfYear(Timestamp timestamp) throws Exception {
    LocalDate localDate = timestamp.toLocalDateTime().toLocalDate();
    return localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear());
  }

  public static Integer weekDay(Timestamp timestamp) throws Exception {
    LocalDate localDate = timestamp.toLocalDateTime().toLocalDate();
    int firstDayOfWeek = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek().getValue();
    if (firstDayOfWeek == 7) {
      return localDate.get(WeekFields.of(Locale.getDefault()).dayOfWeek()) - 2;
    } else {
      return localDate.get(WeekFields.of(Locale.getDefault()).dayOfWeek()) - 1;
    }
  }

  public static Long microSecond(Time time) throws Exception {
    return time.getTime() / 1000;

  }

  public static String convertTZ(Timestamp date, String originTZ, String targetTZ) throws Exception {
    ZoneId zoneId;
    try {
      zoneId = ZoneId.of(targetTZ);
    } catch (Exception e) {
      zoneId = ZoneOffset.of(targetTZ);
    }
    LocalDate localDate = date.toInstant().atZone(zoneId).toLocalDate();
    return DateFormatUtils.format(Date.valueOf(localDate), "yyyy-MM-dd HH:mm:ss");
  }

  public static Integer periodAdd(Integer yearAndMonth, Integer months) throws Exception {
    String text = String.valueOf(yearAndMonth);
    java.util.Date date = DateUtils.parseDate(text, "yyyyMM", "yyMM");
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate newDate = localDate.plusMonths(months);
    return newDate.getYear() * 100 + newDate.getMonthValue();
  }

  public static Integer periodDiff(Integer yearAndMonth1, Integer yearAndMonth2) {
    int months1 = ((yearAndMonth1 / 100) * 12) + yearAndMonth1 % 100;
    int months2 = ((yearAndMonth2 / 100) * 12) + yearAndMonth2 % 100;
    return months1 - months2;
  }

  public static String timeDiff(Timestamp date1, Timestamp date2) throws Exception {
    String sign = "";
    if (date1.getTime() < date2.getTime()) {
      sign = "-";
    }
    Long totalMilliSeconds = Math.abs(date1.getTime() - date2.getTime());
    long milliSeconds = totalMilliSeconds % 1000;
    Long seconds = totalMilliSeconds / 1000 / 60 % 60;
    Long minutes = totalMilliSeconds / 1000 / 3600 % 60;
    long hours = totalMilliSeconds / 1000 / 3600;
    return sign + hours + ":" + padNumber(minutes) + ":" + padNumber(seconds) + "." + milliSeconds;
  }

  private static String padNumber(Long number) {
    if (number < 10L) return "0" + number;
    return String.valueOf(number);
  }

  private static Map<String, String> mysqlToJavaDateFormat() {
    Map<String, String> convert = new HashMap<>();
    convert.put("%a", "E");
    convert.put("%b", "M");
    convert.put("%c", "M");
    convert.put("%d", "dd");
    convert.put("%e", "d");
    convert.put("%f", "S");
    convert.put("%H", "HH");
    convert.put("%h", "H");
    convert.put("%I", "h");
    convert.put("%i", "mm");
    convert.put("%J", "D");
    convert.put("%k", "h");
    convert.put("%l", "h");
    convert.put("%M", "M");
    convert.put("%m", "MM");
    convert.put("%p", "a");
    convert.put("%r", "hh:mm:ss a");
    convert.put("%s", "ss");
    convert.put("%S", "ss");
    convert.put("%T", "HH:mm:ss");
    convert.put("%U", "w");
    convert.put("%u", "w");
    convert.put("%V", "w");
    convert.put("%v", "w");
    convert.put("%W", "EEE");
    convert.put("%w", "F");
    convert.put("%Y", "yyyy");
    convert.put("%y", "yy");
    return convert;
  }

}
