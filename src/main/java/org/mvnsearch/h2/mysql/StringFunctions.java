package org.mvnsearch.h2.mysql;

import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;

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

    public static Integer findInSet(String str, String strSet) {
        if (str == null || strSet == null) return null;
        if (strSet.isEmpty()) return 0;
        return Arrays.asList(strSet.split(",")).indexOf(str) + 1;
    }
}
