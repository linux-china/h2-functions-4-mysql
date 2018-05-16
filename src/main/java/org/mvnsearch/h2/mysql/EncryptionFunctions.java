package org.mvnsearch.h2.mysql;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomUtils;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_224;

/**
 * Encryption functions
 *
 * @author linux_china
 */
public class EncryptionFunctions {


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

    public static String md5(String text) {
        return DigestUtils.md5Hex(text);
    }

    public static String sha1(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return DigestUtils.sha1Hex(text);
    }

    public static String sha(String text) {
        return sha1(text);
    }

    public static String sha2(String text, Integer hashLength) throws Exception {
        if (hashLength == 0 || hashLength == 256) {
            return DigestUtils.sha256Hex(text);
        } else if (hashLength == 224) {
            return new DigestUtils(SHA_224).digestAsHex(text);
        } else if (hashLength == 384) {
            return DigestUtils.sha384Hex(text);
        } else if (hashLength == 512) {
            return DigestUtils.sha512Hex(text);
        }
        return null;
    }

    public static byte[] randomBytes(Integer length) {
        if (length > 0 && length < 1024) {
            return RandomUtils.nextBytes(length);
        }
        return null;
    }
}
