package org.mvnsearch.h2.mysql;

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
}
