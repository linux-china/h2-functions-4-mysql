package org.mvnsearch.h2.mysql;

import org.apache.commons.codec.digest.DigestUtils;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_224;

/**
 * Encryption functions
 *
 * @author linux_china
 */
public class EncryptionFunctions {

    public static String SHA1(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return DigestUtils.sha1Hex(text);
    }

    public static String SHA(String text) {
        return SHA1(text);
    }

    public static String SHA2(String text, Integer hashLength) throws Exception {
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
}
