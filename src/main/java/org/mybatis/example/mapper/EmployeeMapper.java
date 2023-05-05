package org.mybatis.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.example.models.Employee;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employees where id = #{id}")
    Employee findEmployeeById(@Param("id") int id);
}
