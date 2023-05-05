# springboot-mybatis-sql-logging

Tried mybatis logging from the [official site](https://mybatis.org/mybatis-3/logging.html), but it wasn't working. So here's another way to log sql queries & parameters in springboot using mybatis & slf4j.

### Steps to log SQL:
1. Add below dependency in `pom.xml` file.
```xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>2.0.5</version>
</dependency>
```
2. Add below line in your `application.properties` file.
```ini
logging.level.org.mybatis=DEBUG
```
__NOTE__: Adding `logging.level.org.mybatis=TRACE` will also log the query result, such as fetched column-rows & values.


## Result:
```log
2023-05-06T00:40:45.422+05:30 DEBUG 3174 --- [nio-8443-exec-2] o.m.e.m.EmployeeMapper.findEmployeeById  : ==>  Preparing: select * from employees where id = ?
2023-05-06T00:40:45.492+05:30 DEBUG 3174 --- [nio-8443-exec-2] o.m.e.m.EmployeeMapper.findEmployeeById  : ==> Parameters: 2(Integer)
2023-05-06T00:40:45.608+05:30 DEBUG 3174 --- [nio-8443-exec-2] o.m.e.m.EmployeeMapper.findEmployeeById  : <==      Total: 1
```