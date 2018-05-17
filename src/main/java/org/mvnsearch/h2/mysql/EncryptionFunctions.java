package org.mvnsearch.h2.mysql;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_224;

/**
 * Encryption functions
 *
 * @author linux_china
 */
public class EncryptionFunctions {


    public static String hex(byte[] text) {
        return Hex.encodeHexString(text);
    }

    public static byte[] unhex(String text) throws Exception {
        return Hex.decodeHex(text);
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

    public static String sha1(Object text) {
        if (text == null) return null;
        if (text instanceof String) {
            return DigestUtils.sha1Hex((String) text);
        } else if (text instanceof byte[]) {
            return DigestUtils.sha1Hex((byte[]) text);
        }
        return null;
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

    public static byte[] aesEncrypt(Object text, Object password) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, generateSecretKey(password));
        byte[] content;
        if (text instanceof byte[]) {
            content = (byte[]) text;
        } else {
            content = text.toString().getBytes();
        }
        return cipher.doFinal(content);
    }

    public static String aesDecrypt(byte[] content, Object password) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, generateSecretKey(password));
        return new String(cipher.doFinal(content));
    }

    private static SecretKey generateSecretKey(Object password) {
        byte[] content;
        if (password instanceof byte[]) {
            content = (byte[]) password;
        } else {
            content = password.toString().getBytes();
        }
        return new SecretKeySpec(Arrays.copyOfRange(DigestUtils.sha1(content), 0, 16), "AES");
    }
}
