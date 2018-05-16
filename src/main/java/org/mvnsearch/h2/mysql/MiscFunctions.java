package org.mvnsearch.h2.mysql;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * misc functions
 *
 * @author linux_china
 */
public class MiscFunctions {

    public static String version() {
        return "5.6.25";
    }

    public static String format(Double value, Integer p) {
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(p);
        return format.format(value);
    }

    public static String format(Double value, Integer p, String locale) {
        NumberFormat format = NumberFormat.getInstance(new Locale(locale));
        format.setMaximumFractionDigits(p);
        return format.format(value);
    }

}
