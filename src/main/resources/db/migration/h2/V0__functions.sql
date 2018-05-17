-- date & time
CREATE ALIAS UNIX_TIMESTAMP FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.unixTimestamp";
CREATE ALIAS FROM_UNIXTIME FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.fromUnixTime";
CREATE ALIAS ADDDATE FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.addDate";
CREATE ALIAS ADDTIME FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.addTime";
CREATE ALIAS DATE FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.date";
CREATE ALIAS TIME FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.time";
CREATE ALIAS UTC_TIMESTAMP FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.utcTimestamp";
CREATE ALIAS UTC_DATE FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.utcDate";
CREATE ALIAS UTC_TIME FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.utcTime";
CREATE ALIAS FROM_DAYS FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.fromDays";
CREATE ALIAS TO_DAYS FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.toDays";
CREATE ALIAS TO_SECONDS FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.toSeconds";
CREATE ALIAS TIME_TO_SEC FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.timeToSeconds";
CREATE ALIAS DATE_FORMAT FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.dateFormat";
CREATE ALIAS LAST_DAY FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.lastDay";
CREATE ALIAS LOCALTIME FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.now";
CREATE ALIAS LOCALTIMESTAMP FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.now";
CREATE ALIAS MAKEDATE FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.makeDate";
CREATE ALIAS MAKETIME FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.makeTime";
CREATE ALIAS SEC_TO_TIME FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.secondsToTime";
CREATE ALIAS SLEEP FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.sleep";
CREATE ALIAS STR_TO_DATE FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.strToDate";
CREATE ALIAS SUBDATE FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.subDate";
CREATE ALIAS SUBTIME FOR "org.mvnsearch.h2.mysql.DateTimeFunctions.subTime";
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
CREATE ALIAS UUID_SHORT FOR "org.mvnsearch.h2.mysql.StringFunctions.uuidShort";
CREATE ALIAS FIND_IN_SET FOR "org.mvnsearch.h2.mysql.StringFunctions.findInSet";
CREATE ALIAS IS_IPV4 FOR "org.mvnsearch.h2.mysql.StringFunctions.isIpv4";
CREATE ALIAS IS_IPV6 FOR "org.mvnsearch.h2.mysql.StringFunctions.isIpv6";
CREATE ALIAS IS_UUID FOR "org.mvnsearch.h2.mysql.StringFunctions.isUUID";
CREATE ALIAS REVERSE FOR "org.mvnsearch.h2.mysql.StringFunctions.reverse";
CREATE ALIAS SUBSTRING_INDEX FOR "org.mvnsearch.h2.mysql.StringFunctions.subStringIndex";
CREATE ALIAS STRCMP FOR "org.mvnsearch.h2.mysql.StringFunctions.strCmp";
CREATE ALIAS CONNECTION_ID FOR "org.mvnsearch.h2.mysql.MiscFunctions.connectId";
CREATE ALIAS SESSION_USER FOR "org.mvnsearch.h2.mysql.MiscFunctions.sessionUser";
-- math functions
CREATE ALIAS POW FOR "org.mvnsearch.h2.mysql.MathFunctions.pow";
-- misc
CREATE ALIAS FORMAT FOR "org.mvnsearch.h2.mysql.MiscFunctions.format";
CREATE ALIAS VERSION FOR "org.mvnsearch.h2.mysql.MiscFunctions.version";
