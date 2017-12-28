package org.mvnsearch.h2.mysql;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * h2 use defined functions for MySQL
 *
 * @author linux_china
 */
public class Functions {

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
        return dateFormat.parse(text).getTime();
    }

    public static Date fromUnixTime(Long unixTime) {
        return new Date(unixTime * 1000);
    }
}
