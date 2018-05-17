h2-functions-4-mysql
======================
H2 User defined functions for MySQL.

# Why this project?

I always use H2 for unit test instead of real MySQL(Docker), but some MySQL functions are not available in H2.
So I create this project to define some functions for MySQL and make unit test easy.

# How to use?

In you pom.xml add following dependency: 

```xml
<dependency>
    <groupId>org.mvnsearch.mysql</groupId>
    <artifactId>h2-functions-4-mysql</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

* Flyway with Spring Boot: automatically(classpath:db/migration/h2/V0_functions.sql), no configuration.
* Manual: Add following code in your application. datasource is h2 datasource.

```
org.h2.tools.RunScript.execute(dataSource.getConnection(), IOUtils.getReader(this.getClass().getResourceAsStream("/db/migration/h2/V0__functions.sql")));
```

## Function List

N: not available,  Y: same,  A: available

| MySQL   |      H2      |  Status |
|---------|:------------:|--------:|
|ABS|ABS|Y|
|ACOS|ACOS|Y|
|ADDDATE||A|
|ADDTIME||A|
|AES_DECRYPT||A|
|AES_ENCRYPT||A|
|ANY_VALUE||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|ASCII|ASCII|Y|
|ASIN|ASIN|Y|
|ATAN|ATAN|Y|
|ATAN2|ATAN2|Y|
|AVG|AVG|Y|
|BENCHMARK||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|BIN||A|
|BIN_TO_UUID||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|BIT_AND|BIT_AND|Y|
|BIT_COUNT||N|
|BIT_LENGTH|BIT_LENGTH|Y|
|BIT_OR|BIT_OR|Y|
|BIT_XOR||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|CAST|CAST|Y|
|CEIL|CEIL|Y|
|CEILING|CEILING|Y|
|CHAR|CHAR|Y|
|CHAR_LENGTH|CHAR_LENGTH|Y|
|CHARACTER_LENGTH|CHARACTER_LENGTH|Y|
|CHARSET||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|COALESCE|COALESCE|Y|
|COERCIBILITY||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|COLLATION||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|COMPRESS|COMPRESS|Y|
|CONCAT|CONCAT|Y|
|CONCAT_WS|CONCAT_WS|Y|
|CONNECTION_ID||A|
|CONV||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|CONVERT|CONVERT|Y|
|CONVERT_TZ||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|COS|COS|Y|
|COT|COT|Y|
|COUNT|COUNT|Y|
|COUNT|COUNT|Y|
|CRC32||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|CREATE_DH_PARAMETERS||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|CREATE_DIGEST||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|CUME_DIST||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|CURDATE|CURDATE|Y|
|CURRENT_DATE|CURRENT_DATE|Y|
|CURRENT_ROLE||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|CURRENT_TIME|CURRENT_TIME|Y|
|CURRENT_TIMESTAMP|CURRENT_TIMESTAMP|Y|
|CURRENT_USER||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|CURTIME|CURTIME|Y|
|DATABASE|DATABASE|Y|
|DATE||A|
|DATE_ADD||A|
|DATE_FORMAT||A|
|DATE_SUB||A|
|DATEDIFF|DATEDIFF|Y|
|DAY|DAY|Y|
|DAYNAME|DAYNAME|Y|
|DAYOFMONTH|DAYOFMONTH|Y|
|DAYOFWEEK|DAYOFWEEK|Y|
|DAYOFYEAR|DAYOFYEAR|Y|
|DECODE|DECODE|Y|
|DEFAULT||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|DEGREES|DEGREES|Y|
|DENSE_RANK||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|DES_DECRYPT||Deprecated|
|DES_ENCRYPT||Deprecated|
|ELT||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|ENCODE||Deprecated|
|ENCRYPT|ENCRYPT|Y|
|EXP|EXP|Y|
|EXPORT_SET||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|EXTRACT|EXTRACT|Y|
|ExtractValue||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|FIELD||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|FIND_IN_SET||A|
|FIRST_VALUE||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|FLOOR|FLOOR|Y|
|FORMAT||A|
|FOUND_ROWS||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|FROM_BASE64||A|
|FROM_DAYS||A|
|FROM_UNIXTIME||A|
|GeomCollection||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|GeometryCollection||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|GET_DD_COLUMN_PRIVILEGES||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|GET_DD_CREATE_OPTIONS||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|GET_DD_INDEX_SUB_PART_LENGTH||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|GET_FORMAT||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|GET_LOCK||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|GREATEST|GREATEST|Y|
|GROUP_CONCAT|GROUP_CONCAT|Y|
|GTID_SUBSET||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|GTID_SUBTRACT||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|HEX||A|
|HOUR|HOUR|Y|
|ICU_VERSION||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|IF||N|
|IFNULL|IFNULL|Y|
|INET_ATON||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|INET_NTOA||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|INET6_ATON||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|INET6_NTOA||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|INSERT|INSERT|Y|
|INSTR|INSTR|Y|
|INTERVAL||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|IS_FREE_LOCK||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|IS_IPV4||A|
|IS_IPV4_COMPAT||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|IS_IPV4_MAPPED||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|IS_IPV6||A|
|IS_USED_LOCK||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|IS_UUID||A|
|ISNULL||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|LAG||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|LAST_INSERT_ID|LAST_INSERT_ID|Y|
|LAST_VALUE||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|LCASE|LCASE|Y|
|LEAD||N|
|LEAST|LEAST|Y|
|LEFT|LEFT|Y|
|LENGTH|LENGTH|Y|
|LineString||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|LN|LN|Y|
|LOAD_FILE||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|LOCALTIME||A|
|LOCALTIMESTAMP||A|
|LOCATE|LOCATE|Y|
|LOG|LOG|Y|
|LOG10|LOG10|Y|
|LOG2||N|
|LOWER|LOWER|Y|
|LPAD|LPAD|Y|
|LTRIM|LTRIM|Y|
|MAKE_SET||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|MAKEDATE||A|
|MAKETIME||N|
|MASTER_POS_WAIT||N|
|MAX|MAX|Y|
|MBRContains||N|
|MBRCoveredBy||N|
|MBRCovers||N|
|MBRDisjoint||N|
|MBREquals||N|
|MBRIntersects||N|
|MBROverlaps||N|
|MBRTouches||N|
|MBRWithin||N|
|MD5||A|
|MICROSECOND||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|MID||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|MIN|MIN|Y|
|MINUTE|MINUTE|Y|
|MOD|MOD|Y|
|MONTH|MONTH|Y|
|MONTHNAME|MONTHNAME|Y|
|MultiLineString||N|
|MultiPoint||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|MultiPolygon||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|NAME_CONST||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|NOW||A|
|NTH_VALUE||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|NTILE||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|NULLIF|NULLIF|Y|
|OCT||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|OCTET_LENGTH|OCTET_LENGTH|Y|
|ORD||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|PASSWORD||A|
|PERCENT_RANK||N|
|PERIOD_ADD||N|
|PERIOD_DIFF||N|
|PI|PI|Y|
|Point||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|Polygon||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|POSITION|POSITION|Y|
|POW||A|
|POWER|POWER|Y|
|QUARTER|QUARTER|Y|
|QUOTE||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|RADIANS|RADIANS|Y|
|RAND|RAND|Y|
|RANDOM_BYTES||A|
|RANK||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|REGEXP_INSTR||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|REGEXP_LIKE|REGEXP_LIKE|Y|
|REGEXP_REPLACE|REGEXP_REPLACE|Y|
|REGEXP_SUBSTR||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|RELEASE_ALL_LOCKS||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|RELEASE_LOCK||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|REPEAT|REPEAT|Y|
|REPLACE|REPLACE|Y|
|REVERSE||N|
|RIGHT|RIGHT|Y|
|ROLES_GRAPHML||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|ROUND|ROUND|Y|
|ROW_COUNT||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|ROW_NUMBER||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|RPAD|RPAD|Y|
|RTRIM|RTRIM|Y|
|SCHEMA|SCHEMA|Y|
|SEC_TO_TIME||A|
|SECOND|SECOND|Y|
|SESSION_USER||A|
|SHA1||A|
|SHA2||A|
|SIGN|SIGN|Y|
|SIN|SIN|Y|
|SLEEP||A|
|SOUNDEX|SOUNDEX|Y|
|SPACE|SPACE|Y|
|SQRT|SQRT|Y|
|STATEMENT_DIGEST||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|STATEMENT_DIGEST_TEXT||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|STD||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|STDDEV||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|STDDEV_POP|STDDEV_POP|Y|
|STDDEV_SAMP|STDDEV_SAMP|Y|
|STR_TO_DATE||A|
|STRCMP||A|
|SUBDATE||A|
|SUBSTR|SUBSTR|Y|
|SUBSTRING|SUBSTRING|Y|
|SUBSTRING_INDEX||A|
|SUBTIME||A|
|SUM|SUM|Y|
|SYSDATE|SYSDATE|Y|
|SYSTEM_USER||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|TAN|TAN|Y|
|TIME||A|
|TIME_FORMAT||N|
|TIME_TO_SEC||A|
|TIMEDIFF||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|TIMESTAMP||A|
|TIMESTAMPADD||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|TIMESTAMPDIFF||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|TO_BASE64||A|
|TO_DAYS||A|
|TO_SECONDS||A|
|TRIM|TRIM|Y|
|TRUNCATE|TRUNCATE|Y|
|UCASE||A|
|UNCOMPRESS||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|UNCOMPRESSED_LENGTH||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|UNHEX||A|
|UNIX_TIMESTAMP||A|
|UpdateXML||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|UPPER|UPPER|Y|
|USER|USER|Y|
|UTC_DATE||A|
|UTC_TIME||A|
|UTC_TIMESTAMP||A|
|UUID|UUID|A|
|UUID_SHORT||A|
|UUID_TO_BIN||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|VALIDATE_PASSWORD_STRENGTH||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|VALUES||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|VAR_POP|VAR_POP|Y|
|VAR_SAMP|VAR_SAMP|Y|
|VARIANCE||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|VERSION||A|
|WAIT_FOR_EXECUTED_GTID_SET||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|WAIT_UNTIL_SQL_THREAD_AFTER_GTIDS||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|WEEK|WEEK|Y|
|WEEKDAY||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|WEEKOFYEAR||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|WEIGHT_STRING||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|
|YEAR|YEAR|Y|
|YEARWEEK||![#f03c15](https://placehold.it/15/f03c15/000000?text=N)|


# References

* H2 functions: http://www.h2database.com/html/functions.html
* MySQL functions: https://dev.mysql.com/doc/refman/8.0/en/func-op-summary-ref.html
* application-test.properties with H2 MySQL Mode support

```properties
### datasource
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:public;MODE=MYSQL;DATABASE_TO_UPPER=false;INIT=CREATE SCHEMA IF NOT EXISTS public
spring.datasource.username=sa

```