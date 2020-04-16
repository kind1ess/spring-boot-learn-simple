package com.kind1ess.springboot.mapper;

import com.kind1ess.springboot.entity.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmployeeMapper {

    @Select("select * from employee where id=#{id}")
    Employee getEmployeeById(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    void updateEmployee(Employee employee);

    @Delete("delete employee where id=#{id}")
    void deleteEmployee(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastNName},#{email},#{gender},#{dId})")
    void insertEmployee(Employee employee);

    @Select("select * from employee where lastName=#{lastName}")
    Employee getEmployeeByLastName(String lastName);
}
