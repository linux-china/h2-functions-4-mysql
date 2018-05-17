package org.mvnsearch.h2.mysql;

import org.apache.commons.lang3.RandomUtils;

/**
 * String functions
 *
 * @author linux_china
 */
public class StringFunctions {

    public static String bin(Long number) {
        return Long.toBinaryString(number);
    }

    public static Long uuidShort() {
        return RandomUtils.nextLong(Long.MAX_VALUE / 2, Long.MAX_VALUE);
    }
}
