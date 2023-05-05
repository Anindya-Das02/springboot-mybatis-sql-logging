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
2023-05-06T01:28:30.472+05:30 DEBUG 4279 --- [nio-8443-exec-1] o.m.e.m.EmployeeMapper.findEmployeeById  : ==>  Preparing: select * from employees where id = ?
2023-05-06T01:28:30.524+05:30 DEBUG 4279 --- [nio-8443-exec-1] o.m.e.m.EmployeeMapper.findEmployeeById  : ==> Parameters: 2(Integer)
2023-05-06T01:28:30.616+05:30 DEBUG 4279 --- [nio-8443-exec-1] o.m.e.m.EmployeeMapper.findEmployeeById  : <==      Total: 1

2023-05-06T01:34:22.838+05:30 DEBUG 4426 --- [nio-8443-exec-1] o.m.e.m.E.fetchEmployeeList              : ==>  Preparing: select * from employees
2023-05-06T01:34:22.927+05:30 DEBUG 4426 --- [nio-8443-exec-1] o.m.e.m.E.fetchEmployeeList              : ==> Parameters: 
2023-05-06T01:34:22.993+05:30 DEBUG 4426 --- [nio-8443-exec-1] o.m.e.m.E.fetchEmployeeList              : <==      Total: 4

2023-05-06T01:28:35.664+05:30 DEBUG 4279 --- [nio-8443-exec-2] o.m.e.m.E.insertEmployeeDetails          : ==>  Preparing: insert into employees (id, name, yoe, tech) values (?, ?, ?, ?)
2023-05-06T01:28:35.670+05:30 DEBUG 4279 --- [nio-8443-exec-2] o.m.e.m.E.insertEmployeeDetails          : ==> Parameters: 4(Integer), ddd(String), 2(Integer), java, hibernate(String)
2023-05-06T01:28:35.974+05:30 DEBUG 4279 --- [nio-8443-exec-2] o.m.e.m.E.insertEmployeeDetails          : <==    Updates: 1
```

### When `logging.level.org.mybatis=TRACE` is used:
```log
2023-05-06T01:06:47.360+05:30 DEBUG 3852 --- [nio-8443-exec-1] o.m.e.m.EmployeeMapper.findEmployeeById  : ==>  Preparing: select * from employees where id = ?
2023-05-06T01:06:47.428+05:30 DEBUG 3852 --- [nio-8443-exec-1] o.m.e.m.EmployeeMapper.findEmployeeById  : ==> Parameters: 1(Integer)
2023-05-06T01:06:47.584+05:30 TRACE 3852 --- [nio-8443-exec-1] o.m.e.m.EmployeeMapper.findEmployeeById  : <==    Columns: id, name, yoe, tech
2023-05-06T01:06:47.584+05:30 TRACE 3852 --- [nio-8443-exec-1] o.m.e.m.EmployeeMapper.findEmployeeById  : <==        Row: 1, aaa, 3, java, sql
2023-05-06T01:06:47.605+05:30 DEBUG 3852 --- [nio-8443-exec-1] o.m.e.m.EmployeeMapper.findEmployeeById  : <==      Total: 1
```
