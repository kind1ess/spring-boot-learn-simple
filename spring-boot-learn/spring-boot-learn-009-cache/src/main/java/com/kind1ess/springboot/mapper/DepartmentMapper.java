package com.kind1ess.springboot.mapper;

import com.kind1ess.springboot.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    Department getById(Integer id);
}
