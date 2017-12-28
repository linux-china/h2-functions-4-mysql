h2-functions-4-mysql
======================
H2 User defined functions for MySQL.

# Why this project?

I always use H2 for unit test instead of real MySQL(docker), but some MySQL functions are not available in H2.
So I create this project to create H2 user defined functions for MySQL.
 

### function list

* UNIX_TIMESTAMP()


### integration with flyway db

* Please create application-test.properties with following code:

```properties
### datasource
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:public;MODE=MYSQL;DATABASE_TO_UPPER=false;INIT=CREATE SCHEMA IF NOT EXISTS public
spring.datasource.username=sa

```
* create src/test/resources/db/migration/h2/V0__functions.sql with following:

```h2
CREATE ALIAS UNIX_TIMESTAMP FOR "com.lazada.storage.broker.utils.H2Functions.unixTimestamp"
```


## References

* h2 functions: http://www.h2database.com/html/functions.html
* mysql functions: https://dev.mysql.com/doc/refman/5.7/en/func-op-summary-ref.html