-- date & time
CREATE ALIAS UNIX_TIMESTAMP FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.unixTimestamp";
CREATE ALIAS FROM_UNIXTIME FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.fromUnixTime";
CREATE ALIAS ADDDATE FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.addDate";
CREATE ALIAS ADDTIME FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.addTime";
CREATE ALIAS DATE FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.date";
CREATE ALIAS UTC_TIMESTAMP FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.utcTimestamp";
CREATE ALIAS UTC_DATE FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.utcDate";
CREATE ALIAS UTC_TIME FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.utcTime";
-- encrypt
CREATE ALIAS MD5 FOR "org.mvnsearch.h2.mysql.EncryptionFunctions.md5";
CREATE ALIAS SHA1 FOR "org.mvnsearch.h2.mysql.EncryptionFunctions.sha1";
CREATE ALIAS SHA FOR "org.mvnsearch.h2.mysql.EncryptionFunctions.sha";
CREATE ALIAS HEX FOR "org.mvnsearch.h2.mysql.EncryptionFunctions.hex";
CREATE ALIAS UNHEX FOR "org.mvnsearch.h2.mysql.EncryptionFunctions.unhex";
CREATE ALIAS PASSWORD FOR "org.mvnsearch.h2.mysql.EncryptionFunctions.password";
CREATE ALIAS TO_BASE64 FOR "org.mvnsearch.h2.mysql.EncryptionFunctions.base64";
CREATE ALIAS FROM_BASE64 FOR "org.mvnsearch.h2.mysql.EncryptionFunctions.unbase64";
CREATE ALIAS RANDOM_BYTES FOR "org.mvnsearch.h2.mysql.EncryptionFunctions.randomBytes";
CREATE ALIAS AES_ENCRYPT FOR "org.mvnsearch.h2.mysql.EncryptionFunctions.aesEncrypt";
CREATE ALIAS AES_DECRYPT FOR "org.mvnsearch.h2.mysql.EncryptionFunctions.aesDecrypt";
-- string functions
CREATE ALIAS BIN FOR "org.mvnsearch.h2.mysql.StringFunctions.bin";
-- math functions
CREATE ALIAS POW FOR "org.mvnsearch.h2.mysql.MathFunctions.pow";
-- misc
CREATE ALIAS FORMAT FOR "org.mvnsearch.h2.mysql.MiscFunctions.format";
CREATE ALIAS VERSION FOR "org.mvnsearch.h2.mysql.MiscFunctions.version";
