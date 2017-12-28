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


http://11.163.149.52:7001/p/4/qiaolinglong-kids39-magnetic-double-sided-wooden-drawing-board-1496422476-17930482-cf9d685922e4c867950ade609e3e79a9-product.jpg_200x200q90.jpg_.webp
http://filebroker-lzd.alibaba.com/p/4/qiaolinglong-kids39-magnetic-double-sided-wooden-drawing-board-1496422476-17930482-cf9d685922e4c867950ade609e3e79a9-product.jpg_200x200q90.jpg_.webp
https://lzd-img-sg.alicdn.com/p/4/qiaolinglong-kids39-magnetic-double-sided-wooden-drawing-board-1496422476-17930482-cf9d685922e4c867950ade609e3e79a9-product.jpg_200x200q90.jpg_.webp
