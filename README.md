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
* MySQL functions: https://dev.mysql.com/doc/refman/5.7/en/func-op-summary-ref.html
* application-test.properties with H2 MySQL Mode support

```properties
### datasource
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:public;MODE=MYSQL;DATABASE_TO_UPPER=false;INIT=CREATE SCHEMA IF NOT EXISTS public
spring.datasource.username=sa

```

