package org.mvnsearch.h2.mysql;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * misc functions
 *
 * @author linux_china
 */
public class MiscFunctions {

    public static String version() {
        return "5.6.25";
    }

    public static String md5(String text) {
        return DigestUtils.md5Hex(text);
    }

    public static String sha1(String text) {
        return DigestUtils.sha1Hex(text);
    }

    public static String hex(String text) {
        return Hex.encodeHexString(text.getBytes());
    }

    public static String unhex(String text) throws Exception {
        return new String(Hex.decodeHex(text));
    }

    public static String password(String text) throws Exception {
        return "*" + sha1(unhex(sha1(text)));
    }

    public static String base64(String text) throws Exception {
        return Base64.encodeBase64String(text.getBytes());
    }

    public static String unbase64(String text) throws Exception {
        return new String(Base64.decodeBase64(text.getBytes()));
    }



}
