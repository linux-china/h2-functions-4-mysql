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
H2FunctionsLoader.loadMysqlFunctions(dataSource);
```

## Function List

N: not available,  Y: same,  A: available

| MySQL             |        H2         |                                                   Status |
|:------------------|:-----------------:|---------------------------------------------------------:|
| ABS               |        ABS        |                                                        Y |
| ACOS              |       ACOS        |                                                        Y |
| ADDDATE                              ||                                                        A |
| ADDTIME                              ||                                                        A |
| AES_DECRYPT                          ||                                                        A |
| AES_ENCRYPT                          ||                                                        A |
| ANY_VALUE                            ||        ![](https://placehold.it/15/f03c15/000000?text=N) |
| ASCII             |       ASCII       |                                                        Y |
| ASIN              |       ASIN        |                                                        Y |
| ATAN              |       ATAN        |                                                        Y |
| ATAN2             |       ATAN2       |                                                        Y |
| AVG               |        AVG        |                                                        Y |
| BENCHMARK                            || ![](https://placehold.it/15/f03c15/000000?text=N) |
| BIN                                  ||                                                        A |
| BIN_TO_UUID                          || ![](https://placehold.it/15/f03c15/000000?text=N) |
| BIT_AND           |      BIT_AND      |                                                        Y |
| BIT_COUNT                            ||                                                        N |
| BIT_LENGTH        |    BIT_LENGTH     |                                                        Y |
| BIT_OR            |      BIT_OR       |                                                        Y |
| BIT_XOR                              || ![](https://placehold.it/15/f03c15/000000?text=N) |
| CAST              |       CAST        |                                                        Y |
| CEIL              |       CEIL        |                                                        Y |
| CEILING           |      CEILING      |                                                        Y |
| CHAR              |       CHAR        |                                                        Y |
| CHAR_LENGTH       |    CHAR_LENGTH    |                                                        Y |
| CHARACTER_LENGTH  | CHARACTER_LENGTH  |                                                        Y |
| CHARSET                              ||                                                        A |
| COALESCE          |     COALESCE      |                                                        Y |
| COERCIBILITY                         || ![](https://placehold.it/15/f03c15/000000?text=N) |
| COLLATION                            || ![](https://placehold.it/15/f03c15/000000?text=N) |
| COMPRESS          |     COMPRESS      |                                                        Y |
| CONCAT            |      CONCAT       |                                                        Y |
| CONCAT_WS         |     CONCAT_WS     |                                                        Y |
| CONNECTION_ID                        ||                                                        A |
| CONV                                 ||                                                        A |
| CONVERT           |      CONVERT      |                                                        Y |
| CONVERT_TZ                           ||                                                        A |
| COS               |        COS        |                                                        Y |
| COT               |        COT        |                                                        Y |
| COUNT             |       COUNT       |                                                        Y |
| COUNT             |       COUNT       |                                                        Y |
| CRC32                                ||                                                        A |
| CREATE_DH_PARAMETERS                 || ![](https://placehold.it/15/f03c15/000000?text=N) |
| CREATE_DIGEST                        ||                                                        A |
| CUME_DIST                            || ![](https://placehold.it/15/f03c15/000000?text=N) |
| CURDATE           |      CURDATE      |                                                        Y |
| CURRENT_DATE      |   CURRENT_DATE    |                                                        Y |
| CURRENT_ROLE                         ||                                                        A |
| CURRENT_TIME      |   CURRENT_TIME    |                                                        Y |
| CURRENT_TIMESTAMP | CURRENT_TIMESTAMP |                                                        Y |
| CURRENT_USER                         ||                                                        A |
| CURTIME           |      CURTIME      |                                                        Y |
| DATABASE          |     DATABASE      |                                                        Y |
| DATE                                 ||                                                        A |
| DATE_ADD                             ||                                                        A |
| DATE_FORMAT                          ||                                                        A |
| DATE_SUB                             ||                                                        A |
| DATEDIFF          |     DATEDIFF      |                                                        Y |
| DAY               |        DAY        |                                                        Y |
| DAYNAME           |      DAYNAME      |                                                        Y |
| DAYOFMONTH        |    DAYOFMONTH     |                                                        Y |
| DAYOFWEEK         |     DAYOFWEEK     |                                                        Y |
| DAYOFYEAR         |     DAYOFYEAR     |                                                        Y |
| DECODE            |      DECODE       |                                                        Y |
| DEFAULT                              || ![](https://placehold.it/15/f03c15/000000?text=N) |
| DEGREES           |      DEGREES      |                                                        Y |
| DENSE_RANK                           || ![](https://placehold.it/15/f03c15/000000?text=N) |
| DES_DECRYPT                          ||                                               Deprecated |
| DES_ENCRYPT                          ||                                               Deprecated |
| ELT                                  || ![](https://placehold.it/15/f03c15/000000?text=N) |
| ENCODE                               ||                                               Deprecated |
| ENCRYPT           |      ENCRYPT      |                                                        Y |
| EXP               |        EXP        |                                                        Y |
| EXPORT_SET                           || ![](https://placehold.it/15/f03c15/000000?text=N) |
| EXTRACT           |      EXTRACT      |                                                        Y |
| ExtractValue                         || ![](https://placehold.it/15/f03c15/000000?text=N) |
| FIELD                                ||                                                        A |
| FIND_IN_SET                          ||                                                        A |
| FIRST_VALUE                          || ![](https://placehold.it/15/f03c15/000000?text=N) |
| FLOOR             |       FLOOR       |                                                        Y |
| FORMAT                               ||                                                        A |
| FOUND_ROWS                           || ![](https://placehold.it/15/f03c15/000000?text=N) |
| FROM_BASE64                          ||                                                        A |
| FROM_DAYS                            ||                                                        A |
| FROM_UNIXTIME                        ||                                                        A |
| GeomCollection                       || ![](https://placehold.it/15/f03c15/000000?text=N) |
| GeometryCollection                   || ![](https://placehold.it/15/f03c15/000000?text=N) |
| GET_DD_COLUMN_PRIVILEGES             || ![](https://placehold.it/15/f03c15/000000?text=N) |
| GET_DD_CREATE_OPTIONS                || ![](https://placehold.it/15/f03c15/000000?text=N) |
| GET_DD_INDEX_SUB_PART_LENGTH         || ![](https://placehold.it/15/f03c15/000000?text=N) |
| GET_FORMAT                           || ![](https://placehold.it/15/f03c15/000000?text=N) |
| GET_LOCK                             || ![](https://placehold.it/15/f03c15/000000?text=N) |
| GREATEST          |     GREATEST      |                                                        Y |
| GROUP_CONCAT      |   GROUP_CONCAT    |                                                        Y |
| GTID_SUBSET                          || ![](https://placehold.it/15/f03c15/000000?text=N) |
| GTID_SUBTRACT                        || ![](https://placehold.it/15/f03c15/000000?text=N) |
| HEX                                  ||                                                        A |
| HOUR              |       HOUR        |                                                        Y |
| ICU_VERSION                          || ![](https://placehold.it/15/f03c15/000000?text=N) |
| IF                                   ||                                                        N |
| IFNULL            |      IFNULL       |                                                        Y |
| INET_ATON                            || ![](https://placehold.it/15/f03c15/000000?text=N) |
| INET_NTOA                            || ![](https://placehold.it/15/f03c15/000000?text=N) |
| INET6_ATON                           || ![](https://placehold.it/15/f03c15/000000?text=N) |
| INET6_NTOA                           || ![](https://placehold.it/15/f03c15/000000?text=N) |
| INSERT            |      INSERT       |                                                        Y |
| INSTR             |       INSTR       |                                                        Y |
| INTERVAL                             || ![](https://placehold.it/15/f03c15/000000?text=N) |
| IS_FREE_LOCK                         || ![](https://placehold.it/15/f03c15/000000?text=N) |
| IS_IPV4                              ||                                                        A |
| IS_IPV4_COMPAT                       || ![](https://placehold.it/15/f03c15/000000?text=N) |
| IS_IPV4_MAPPED                       || ![](https://placehold.it/15/f03c15/000000?text=N) |
| IS_IPV6                              ||                                                        A |
| IS_USED_LOCK                         || ![](https://placehold.it/15/f03c15/000000?text=N) |
| IS_UUID                              ||                                                        A |
| ISNULL                               || ![](https://placehold.it/15/f03c15/000000?text=N) |
| LAG                                  || ![](https://placehold.it/15/f03c15/000000?text=N) |
| LAST_INSERT_ID    |  LAST_INSERT_ID   |                                                        Y |
| LAST_VALUE                           || ![](https://placehold.it/15/f03c15/000000?text=N) |
| LCASE             |       LCASE       |                                                        Y |
| LEAD                                 ||                                                        N |
| LEAST             |       LEAST       |                                                        Y |
| LEFT              |       LEFT        |                                                        Y |
| LENGTH            |      LENGTH       |                                                        Y |
| LineString                           || ![](https://placehold.it/15/f03c15/000000?text=N) |
| LN                |        LN         |                                                        Y |
| LOAD_FILE                            || ![](https://placehold.it/15/f03c15/000000?text=N) |
| LOCALTIME                            ||                                                        A |
| LOCALTIMESTAMP                       ||                                                        A |
| LOCATE            |      LOCATE       |                                                        Y |
| LOG               |        LOG        |                                                        Y |
| LOG10             |       LOG10       |                                                        Y |
| LOG2                                 ||                                                        N |
| LOWER             |       LOWER       |                                                        Y |
| LPAD              |       LPAD        |                                                        Y |
| LTRIM             |       LTRIM       |                                                        Y |
| MAKE_SET                             || ![](https://placehold.it/15/f03c15/000000?text=N) |
| MAKEDATE                             ||                                                        A |
| MAKETIME                             ||                                                        Y |
| MASTER_POS_WAIT                      ||                                                        N |
| MAX               |        MAX        |                                                        Y |
| MBRContains                          ||                                                        N |
| MBRCoveredBy                         ||                                                        N |
| MBRCovers                            ||                                                        N |
| MBRDisjoint                          ||                                                        N |
| MBREquals                            ||                                                        N |
| MBRIntersects                        ||                                                        N |
| MBROverlaps                          ||                                                        N |
| MBRTouches                           ||                                                        N |
| MBRWithin                            ||                                                        N |
| MD5                                  ||                                                        A |
| MICROSECOND                          ||                                                        A |
| MID                                  ||                                                        A |
| MIN               |        MIN        |                                                        Y |
| MINUTE            |      MINUTE       |                                                        Y |
| MOD               |        MOD        |                                                        Y |
| MONTH             |       MONTH       |                                                        Y |
| MONTHNAME         |     MONTHNAME     |                                                        Y |
| MultiLineString                      ||                                                        N |
| MultiPoint                           || ![](https://placehold.it/15/f03c15/000000?text=N) |
| MultiPolygon                         || ![](https://placehold.it/15/f03c15/000000?text=N) |
| NAME_CONST                           || ![](https://placehold.it/15/f03c15/000000?text=N) |
| NOW                                  ||                                                        A |
| NTH_VALUE                            || ![](https://placehold.it/15/f03c15/000000?text=N) |
| NTILE                                || ![](https://placehold.it/15/f03c15/000000?text=N) |
| NULLIF            |      NULLIF       |                                                        Y |
| OCT                                  || ![](https://placehold.it/15/f03c15/000000?text=N) |
| OCTET_LENGTH      |   OCTET_LENGTH    |                                                        Y |
| ORD                                  ||                                                        A |
| PASSWORD                             ||                                                        A |
| PERCENT_RANK                         ||                                                        N |
| PERIOD_ADD                           ||                                                        A |
| PERIOD_DIFF                          ||                                                        A |
| PI                |        PI         |                                                        Y |
| Point                                || ![](https://placehold.it/15/f03c15/000000?text=N) |
| Polygon                              || ![](https://placehold.it/15/f03c15/000000?text=N) |
| POSITION          |     POSITION      |                                                        Y |
| POW                                  ||                                                        A |
| POWER             |       POWER       |                                                        Y |
| QUARTER           |      QUARTER      |                                                        Y |
| QUOTE                                ||                                                        A |
| RADIANS           |      RADIANS      |                                                        Y |
| RAND              |       RAND        |                                                        Y |
| RANDOM_BYTES                         ||                                                        A |
| RANK                                 || ![](https://placehold.it/15/f03c15/000000?text=N) |
| REGEXP_INSTR                         || ![](https://placehold.it/15/f03c15/000000?text=N) |
| REGEXP_LIKE       |    REGEXP_LIKE    |                                                        Y |
| REGEXP_REPLACE    |  REGEXP_REPLACE   |                                                        Y |
| REGEXP_SUBSTR                        || ![](https://placehold.it/15/f03c15/000000?text=N) |
| RELEASE_ALL_LOCKS                    || ![](https://placehold.it/15/f03c15/000000?text=N) |
| RELEASE_LOCK                         || ![](https://placehold.it/15/f03c15/000000?text=N) |
| REPEAT            |      REPEAT       |                                                        Y |
| REPLACE           |      REPLACE      |                                                        Y |
| REVERSE                              ||                                                        A |
| RIGHT             |       RIGHT       |                                                        Y |
| ROLES_GRAPHML                        || ![](https://placehold.it/15/f03c15/000000?text=N) |
| ROUND             |       ROUND       |                                                        Y |
| ROW_COUNT                            || ![](https://placehold.it/15/f03c15/000000?text=N) |
| ROW_NUMBER                           || ![](https://placehold.it/15/f03c15/000000?text=N) |
| RPAD              |       RPAD        |                                                        Y |
| RTRIM             |       RTRIM       |                                                        Y |
| SCHEMA            |      SCHEMA       |                                                        Y |
| SEC_TO_TIME                          ||                                                        A |
| SECOND            |      SECOND       |                                                        Y |
| SESSION_USER                         ||                                                        A |
| SHA1                                 ||                                                        A |
| SHA2                                 ||                                                        A |
| SIGN              |       SIGN        |                                                        Y |
| SIN               |        SIN        |                                                        Y |
| SLEEP                                ||                                                        A |
| SOUNDEX           |      SOUNDEX      |                                                        Y |
| SPACE             |       SPACE       |                                                        Y |
| SQRT              |       SQRT        |                                                        Y |
| STATEMENT_DIGEST                     || ![](https://placehold.it/15/f03c15/000000?text=N) |
| STATEMENT_DIGEST_TEXT                || ![](https://placehold.it/15/f03c15/000000?text=N) |
| STD                                  || ![](https://placehold.it/15/f03c15/000000?text=N) |
| STDDEV                               || ![](https://placehold.it/15/f03c15/000000?text=N) |
| STDDEV_POP        |    STDDEV_POP     |                                                        Y |
| STDDEV_SAMP       |    STDDEV_SAMP    |                                                        Y |
| STR_TO_DATE                          ||                                                        A |
| STRCMP                               ||                                                        A |
| SUBDATE                              ||                                                        A |
| SUBSTR            |      SUBSTR       |                                                        Y |
| SUBSTRING         |     SUBSTRING     |                                                        Y |
| SUBSTRING_INDEX                      ||                                                        A |
| SUBTIME                              ||                                                        A |
| SUM               |        SUM        |                                                        Y |
| SYSDATE           |      SYSDATE      |                                                        Y |
| SYSTEM_USER                          ||                                                        A |
| TAN               |        TAN        |                                                        Y |
| TIME                                 ||                                                        A |
| TIME_FORMAT                          ||                                                        A |
| TIME_TO_SEC                          ||                                                        A |
| TIMEDIFF                             ||                                                        A |
| TIMESTAMP                            ||                                                        A |
| TIMESTAMPADD                         || ![](https://placehold.it/15/f03c15/000000?text=N) |
| TIMESTAMPDIFF                        || ![](https://placehold.it/15/f03c15/000000?text=N) |
| TO_BASE64                            ||                                                        A |
| TO_DAYS                              ||                                                        A |
| TO_SECONDS                           ||                                                        A |
| TRIM              |       TRIM        |                                                        Y |
| TRUNCATE          |     TRUNCATE      |                                                        Y |
| UCASE                                ||                                                        A |
| UNCOMPRESS                           || ![](https://placehold.it/15/f03c15/000000?text=N) |
| UNCOMPRESSED_LENGTH                  || ![](https://placehold.it/15/f03c15/000000?text=N) |
| UNHEX                                ||                                                        A |
| UNIX_TIMESTAMP                       ||                                                        A |
| UpdateXML                            || ![](https://placehold.it/15/f03c15/000000?text=N) |
| UPPER             |       UPPER       |                                                        Y |
| USER              |       USER        |                                                        Y |
| UTC_DATE                             ||                                                        A |
| UTC_TIME                             ||                                                        A |
| UTC_TIMESTAMP                        ||                                                        A |
| UUID              |       UUID        |                                                        A |
| UUID_SHORT                           ||                                                        A |
| UUID_TO_BIN                          || ![](https://placehold.it/15/f03c15/000000?text=N) |
| VALIDATE_PASSWORD_STRENGTH           || ![](https://placehold.it/15/f03c15/000000?text=N) |
| VALUES                               || ![](https://placehold.it/15/f03c15/000000?text=N) |
| VAR_POP           |      VAR_POP      |                                                        Y |
| VAR_SAMP          |     VAR_SAMP      |                                                        Y |
| VARIANCE                             || ![](https://placehold.it/15/f03c15/000000?text=N) |
| VERSION                              ||                                                        A |
| WAIT_FOR_EXECUTED_GTID_SET           || ![](https://placehold.it/15/f03c15/000000?text=N) |
| WAIT_UNTIL_SQL_THREAD_AFTER_GTIDS    || ![](https://placehold.it/15/f03c15/000000?text=N) |
| WEEK              |       WEEK        |                                                        Y |
| WEEKDAY                              ||                                                        A |
| WEEKOFYEAR                           ||                                                        A |
| WEIGHT_STRING                        || ![](https://placehold.it/15/f03c15/000000?text=N) |
| YEAR              |       YEAR        |                                                        Y |
| YEARWEEK                             ||                                                        A |


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