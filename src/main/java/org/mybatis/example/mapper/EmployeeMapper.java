package org.mybatis.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.example.models.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employees where id = #{id}")
    Employee findEmployeeById(@Param("id") int id);

    @Insert("insert into employees (id, name, yoe, tech) values (#{emp.id}, #{emp.name}, #{emp.yoe}, #{emp.tech})")
    void insertEmployeeDetails(@Param("emp") Employee employee);

    @Select("select * from employees")
    List<Employee> fetchEmployeeList();
}
