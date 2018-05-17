package org.mvnsearch.h2.mysql;

import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * String functions
 *
 * @author linux_china
 */
public class StringFunctions {
    private static final Pattern IP_ADDRESS_PATTERN = Pattern.compile(
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

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

    public static Integer isIpv4(String ip) {
        return IP_ADDRESS_PATTERN.matcher(ip).matches() ? 1 : 0;
    }

    public static Integer isIpv6(String ip) {
        return ip.matches("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$")
                || ip.matches("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$")
                ? 1 : 0;

    }

    public static Integer isUUID(String uuid) {
        return uuid.matches("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$") ? 1 : 0;
    }
}
