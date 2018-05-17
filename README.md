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

# Functions

### String functions

* hex & unhex
* FROM_BASE64 & TO_BASE64
* FORMAT

### Date & Time

* UNIX_TIMESTAMP()
* FROM_UNIXTIME()

### cast function

### Bit function

### encryption & compression

* md5
* sha1
* password

### json function

Todo

### Miscellaneous functions

* version

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
|ANY_VALUE||N|
|ASCII|ASCII|Y|
|ASIN|ASIN|Y|
|ASYMMETRIC_DECRYPT||N|
|ASYMMETRIC_DERIVE||N|
|ASYMMETRIC_ENCRYPT||N|
|ASYMMETRIC_SIGN||N|
|ASYMMETRIC_VERIFY||N|
|ATAN|ATAN|Y|
|ATAN2|ATAN2|Y|
|AVG|AVG|Y|
|BENCHMARK||N|
|BIN||A|
|BIN_TO_UUID||N|
|BIT_AND|BIT_AND|Y|
|BIT_COUNT||N|
|BIT_LENGTH|BIT_LENGTH|Y|
|BIT_OR|BIT_OR|Y|
|BIT_XOR||N|
|CAN_ACCESS_COLUMN||N|
|CAN_ACCESS_DATABASE||N|
|CAN_ACCESS_TABLE||N|
|CAN_ACCESS_VIEW||N|
|CAST|CAST|Y|
|CEIL|CEIL|Y|
|CEILING|CEILING|Y|
|CHAR|CHAR|Y|
|CHAR_LENGTH|CHAR_LENGTH|Y|
|CHARACTER_LENGTH|CHARACTER_LENGTH|Y|
|CHARSET||N|
|COALESCE|COALESCE|Y|
|COERCIBILITY||N|
|COLLATION||N|
|COMPRESS|COMPRESS|Y|
|CONCAT|CONCAT|Y|
|CONCAT_WS|CONCAT_WS|Y|
|CONNECTION_ID||N|
|CONV||N|
|CONVERT|CONVERT|Y|
|CONVERT_TZ||N|
|COS|COS|Y|
|COT|COT|Y|
|COUNT|COUNT|Y|
|COUNT|COUNT|Y|
|CRC32||N|
|CREATE_ASYMMETRIC_PRIV_KEY||N|
|CREATE_ASYMMETRIC_PUB_KEY||N|
|CREATE_DH_PARAMETERS||N|
|CREATE_DIGEST||N|
|CUME_DIST||N|
|CURDATE|CURDATE|Y|
|CURRENT_DATE|CURRENT_DATE|Y|
|CURRENT_ROLE||N|
|CURRENT_TIME|CURRENT_TIME|Y|
|CURRENT_TIMESTAMP|CURRENT_TIMESTAMP|Y|
|CURRENT_USER||N|
|CURTIME|CURTIME|Y|
|DATABASE|DATABASE|Y|
|DATE||A|
|DATE_ADD||N|
|DATE_FORMAT||N|
|DATE_SUB||N|
|DATEDIFF|DATEDIFF|Y|
|DAY|DAY|Y|
|DAYNAME|DAYNAME|Y|
|DAYOFMONTH|DAYOFMONTH|Y|
|DAYOFWEEK|DAYOFWEEK|Y|
|DAYOFYEAR|DAYOFYEAR|Y|
|DECODE|DECODE|Y|
|DEFAULT||N|
|DEGREES|DEGREES|Y|
|DENSE_RANK||N|
|DES_DECRYPT||Deprecated|
|DES_ENCRYPT||Deprecated|
|ELT||N|
|ENCODE||Deprecated|
|ENCRYPT|ENCRYPT|Y|
|EXP|EXP|Y|
|EXPORT_SET||N|
|EXTRACT|EXTRACT|Y|
|ExtractValue||N|
|FIELD||N|
|FIND_IN_SET||N|
|FIRST_VALUE||N|
|FLOOR|FLOOR|Y|
|FORMAT||A|
|FOUND_ROWS||N|
|FROM_BASE64||A|
|FROM_DAYS||A|
|FROM_UNIXTIME||A|
|GeomCollection||N|
|GeometryCollection||N|
|GET_DD_COLUMN_PRIVILEGES||N|
|GET_DD_CREATE_OPTIONS||N|
|GET_DD_INDEX_SUB_PART_LENGTH||N|
|GET_FORMAT||N|
|GET_LOCK||N|
|GREATEST|GREATEST|Y|
|GROUP_CONCAT|GROUP_CONCAT|Y|
|GROUPING||N|
|GTID_SUBSET||N|
|GTID_SUBTRACT||N|
|HEX||A|
|HOUR|HOUR|Y|
|ICU_VERSION||N|
|IF||N|
|IFNULL|IFNULL|Y|
|INET_ATON||N|
|INET_NTOA||N|
|INET6_ATON||N|
|INET6_NTOA||N|
|INSERT|INSERT|Y|
|INSTR|INSTR|Y|
|INTERNAL_AUTO_INCREMENT||N|
|INTERNAL_AVG_ROW_LENGTH||N|
|INTERNAL_CHECK_TIME||N|
|INTERNAL_CHECKSUM||N|
|INTERNAL_DATA_FREE||N|
|INTERNAL_DATA_LENGTH||N|
|INTERNAL_DD_CHAR_LENGTH||N|
|INTERNAL_GET_COMMENT_OR_ERROR||N|
|INTERNAL_GET_VIEW_WARNING_OR_ERROR||N|
|INTERNAL_INDEX_COLUMN_CARDINALITY||N|
|INTERNAL_INDEX_LENGTH||N|
|INTERNAL_KEYS_DISABLED||N|
|INTERNAL_MAX_DATA_LENGTH||N|
|INTERNAL_TABLE_ROWS||N|
|INTERNAL_UPDATE_TIME||N|
|INTERVAL||N|
|IS_FREE_LOCK||N|
|IS_IPV4||A|
|IS_IPV4_COMPAT||N|
|IS_IPV4_MAPPED||N|
|IS_IPV6||A|
|IS_USED_LOCK||N|
|IS_UUID||A|
|ISNULL||N|
|JSON_ARRAY||N|
|JSON_ARRAY_APPEND||N|
|JSON_ARRAY_INSERT||N|
|JSON_ARRAYAGG||N|
|JSON_CONTAINS||N|
|JSON_CONTAINS_PATH||N|
|JSON_DEPTH||N|
|JSON_EXTRACT||N|
|JSON_INSERT||N|
|JSON_KEYS||N|
|JSON_LENGTH||N|
|JSON_MERGE||N|
|JSON_MERGE_PATCH||N|
|JSON_MERGE_PRESERVE||N|
|JSON_OBJECT||N|
|JSON_OBJECTAGG||N|
|JSON_PRETTY||N|
|JSON_QUOTE||N|
|JSON_REMOVE||N|
|JSON_REPLACE||N|
|JSON_SEARCH||N|
|JSON_SET||N|
|JSON_STORAGE_FREE||N|
|JSON_STORAGE_SIZE||N|
|JSON_TABLE||N|
|JSON_TYPE||N|
|JSON_UNQUOTE||N|
|JSON_VALID||N|
|LAG||N|
|LAST_INSERT_ID|LAST_INSERT_ID|Y|
|LAST_VALUE||N|
|LCASE|LCASE|Y|
|LEAD||N|
|LEAST|LEAST|Y|
|LEFT|LEFT|Y|
|LENGTH|LENGTH|Y|
|LineString||N|
|LN|LN|Y|
|LOAD_FILE||N|
|LOCALTIME||A|
|LOCALTIMESTAMP||A|
|LOCATE|LOCATE|Y|
|LOG|LOG|Y|
|LOG10|LOG10|Y|
|LOG2||N|
|LOWER|LOWER|Y|
|LPAD|LPAD|Y|
|LTRIM|LTRIM|Y|
|MAKE_SET||N|
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
|MICROSECOND||N|
|MID||N|
|MIN|MIN|Y|
|MINUTE|MINUTE|Y|
|MOD|MOD|Y|
|MONTH|MONTH|Y|
|MONTHNAME|MONTHNAME|Y|
|MultiLineString||N|
|MultiPoint||N|
|MultiPolygon||N|
|NAME_CONST||N|
|NOW||A|
|NTH_VALUE||N|
|NTILE||N|
|NULLIF|NULLIF|Y|
|OCT||N|
|OCTET_LENGTH|OCTET_LENGTH|Y|
|ORD||N|
|PASSWORD||A|
|PERCENT_RANK||N|
|PERIOD_ADD||N|
|PERIOD_DIFF||N|
|PI|PI|Y|
|Point||N|
|Polygon||N|
|POSITION|POSITION|Y|
|POW||A|
|POWER|POWER|Y|
|QUARTER|QUARTER|Y|
|QUOTE||N|
|RADIANS|RADIANS|Y|
|RAND|RAND|Y|
|RANDOM_BYTES||A|
|RANK||N|
|REGEXP_INSTR||N|
|REGEXP_LIKE|REGEXP_LIKE|Y|
|REGEXP_REPLACE|REGEXP_REPLACE|Y|
|REGEXP_SUBSTR||N|
|RELEASE_ALL_LOCKS||N|
|RELEASE_LOCK||N|
|REPEAT|REPEAT|Y|
|REPLACE|REPLACE|Y|
|REVERSE||N|
|RIGHT|RIGHT|Y|
|ROLES_GRAPHML||N|
|ROUND|ROUND|Y|
|ROW_COUNT||N|
|ROW_NUMBER||N|
|RPAD|RPAD|Y|
|RTRIM|RTRIM|Y|
|SCHEMA|SCHEMA|Y|
|SEC_TO_TIME||A|
|SECOND|SECOND|Y|
|SESSION_USER||N|
|SHA1||A|
|SHA2||A|
|SIGN|SIGN|Y|
|SIN|SIN|Y|
|SLEEP||A|
|SOUNDEX|SOUNDEX|Y|
|SPACE|SPACE|Y|
|SQRT|SQRT|Y|
|ST_Area||N|
|ST_AsBinary||N|
|ST_AsGeoJSON||N|
|ST_AsText||N|
|ST_Buffer||N|
|ST_Buffer_Strategy||N|
|ST_Centroid||N|
|ST_Contains||N|
|ST_ConvexHull||N|
|ST_Crosses||N|
|ST_Difference||N|
|ST_Dimension||N|
|ST_Disjoint||N|
|ST_Distance||N|
|ST_Distance_Sphere||N|
|ST_EndPoint||N|
|ST_Envelope||N|
|ST_Equals||N|
|ST_ExteriorRing||N|
|ST_GeoHash||N|
|ST_GeomCollFromText||N|
|ST_GeomCollFromWKB||N|
|ST_GeometryN||N|
|ST_GeometryType||N|
|ST_GeomFromGeoJSON||N|
|ST_GeomFromText||N|
|ST_GeomFromWKB||N|
|ST_InteriorRingN||N|
|ST_Intersection||N|
|ST_Intersects||N|
|ST_IsClosed||N|
|ST_IsEmpty||N|
|ST_IsSimple||N|
|ST_IsValid||N|
|ST_LatFromGeoHash||N|
|ST_Latitude||N|
|ST_Length||N|
|ST_LineFromText||N|
|ST_LineFromWKB||N|
|ST_LongFromGeoHash||N|
|ST_Longitude||N|
|ST_MakeEnvelope||N|
|ST_MLineFromText||N|
|ST_MLineFromWKB||N|
|ST_MPointFromText||N|
|ST_MPointFromWKB||N|
|ST_MPolyFromText||N|
|ST_MPolyFromWKB||N|
|ST_NumGeometries||N|
|ST_NumInteriorRing||N|
|ST_NumPoints||N|
|ST_Overlaps||N|
|ST_PointFromGeoHash||N|
|ST_PointFromText||N|
|ST_PointFromWKB||N|
|ST_PointN||N|
|ST_PolyFromText||N|
|ST_PolyFromWKB||N|
|ST_Simplify||N|
|ST_SRID||N|
|ST_StartPoint||N|
|ST_SwapXY||N|
|ST_SymDifference||N|
|ST_Touches||N|
|ST_Union||N|
|ST_Validate||N|
|ST_Within||N|
|ST_X||N|
|ST_Y||N|
|STATEMENT_DIGEST||N|
|STATEMENT_DIGEST_TEXT||N|
|STD||N|
|STDDEV||N|
|STDDEV_POP|STDDEV_POP|Y|
|STDDEV_SAMP|STDDEV_SAMP|Y|
|STR_TO_DATE||N|
|STRCMP||N|
|SUBDATE||A|
|SUBSTR|SUBSTR|Y|
|SUBSTRING|SUBSTRING|Y|
|SUBSTRING_INDEX||N|
|SUBTIME||N|
|SUM|SUM|Y|
|SYSDATE|SYSDATE|Y|
|SYSTEM_USER||N|
|TAN|TAN|Y|
|TIME||A|
|TIME_FORMAT||N|
|TIME_TO_SEC||A|
|TIMEDIFF||N|
|TIMESTAMP||N|
|TIMESTAMPADD||N|
|TIMESTAMPDIFF||N|
|TO_BASE64||A|
|TO_DAYS||A|
|TO_SECONDS||A|
|TRIM|TRIM|Y|
|TRUNCATE|TRUNCATE|Y|
|UCASE||A|
|UNCOMPRESS||N|
|UNCOMPRESSED_LENGTH||N|
|UNHEX||A|
|UNIX_TIMESTAMP||A|
|UpdateXML||N|
|UPPER|UPPER|Y|
|USER|USER|Y|
|UTC_DATE||A|
|UTC_TIME||A|
|UTC_TIMESTAMP||A|
|UUID|UUID|N|
|UUID_SHORT||A|
|UUID_TO_BIN||N|
|VALIDATE_PASSWORD_STRENGTH||N|
|VALUES||N|
|VAR_POP|VAR_POP|Y|
|VAR_SAMP|VAR_SAMP|Y|
|VARIANCE||N|
|VERSION||A|
|WAIT_FOR_EXECUTED_GTID_SET||N|
|WAIT_UNTIL_SQL_THREAD_AFTER_GTIDS||N|
|WEEK|WEEK|Y|
|WEEKDAY||N|
|WEEKOFYEAR||N|
|WEIGHT_STRING||N|
|YEAR|YEAR|Y|
|YEARWEEK||N|

