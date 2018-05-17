package org.mvnsearch.h2.mysql;

import java.util.UUID;

/**
 * String functions
 *
 * @author linux_china
 */
public class StringFunctions {

    public static String bin(Long number) {
        return Long.toBinaryString(number);
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static Integer charLength(String text) {
        return text.toCharArray().length;
    }
}
