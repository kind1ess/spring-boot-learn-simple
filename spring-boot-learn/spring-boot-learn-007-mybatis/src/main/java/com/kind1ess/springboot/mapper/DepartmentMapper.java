package com.kind1ess.springboot.mapper;

import com.kind1ess.springboot.model.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//指定这是一个操作数据库的mapper
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")//将主键封装到传入的对象中
    @Insert("insert into department(departmentName) values(#{departmentName})")
    int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    int updateDept(Department department);
}
