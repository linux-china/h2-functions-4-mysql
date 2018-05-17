package org.mvnsearch.h2.mysql;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

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

    public static String reverse(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    public static String subStringIndex(String text, String delim, Integer count) {
        String newDelim = delim;
        if (delim.contains(".")) {
            newDelim = StringUtils.replace(delim, ".", "\\.");
        }
        String[] parts = text.split(newDelim);
        if (count > 0) {
            return String.join(delim, Arrays.copyOfRange(parts, 0, count < parts.length ? count : parts.length));
        } else {
            return String.join(delim, Arrays.copyOfRange(parts, parts.length + count < 0 ? 0 : parts.length + count, parts.length));
        }
    }

    public static Integer strCmp(String text1, String text2) {
        return text1.compareTo(text2);
    }

    public static String charset(String text) {
        return "utf-8";
    }

    public static String mid(String text, Integer start) {
        return text.substring(start);
    }

    public static String mid(String text, Integer start, Integer length) {
        int newStart = start;
        if (start < 0) {
            newStart = start + text.length();
            if (newStart < 0) {
                newStart = 0;
            }
        }
        int end = newStart + length;
        if (end > text.length()) {
            end = text.length();
        }
        return text.substring(newStart, end);
    }

    public static Integer field(String... args) {
        for (int i = 1; i < args.length; i++) {
            if (args[i].equals(args[0])) {
                return i;
            }
        }
        return 0;
    }

    public static byte[] compress(String text) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        OutputStream out = new DeflaterOutputStream(bos);
        ByteArrayInputStream in = new ByteArrayInputStream(text.getBytes());
        shovelInToOut(in, out);
        in.close();
        out.close();
        return bos.toByteArray();
    }

    public static String unCompress(byte[] compressed) throws Exception {
        InputStream in =
                new InflaterInputStream(new ByteArrayInputStream(compressed));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        shovelInToOut(in, out);
        in.close();
        out.close();
        return new String(out.toByteArray());
    }

    /**
     * Shovels all data from an input stream to an output stream.
     */
    private static void shovelInToOut(InputStream in, OutputStream out)
            throws IOException {
        byte[] buffer = new byte[1000];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }
}
