package com.kind1ess.springboot.service;


import com.kind1ess.springboot.entity.Department;
import com.kind1ess.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@CacheConfig(cacheNames = "dept")
public class DeptService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Cacheable(key = "#id")
    public Department getById(Integer id){
        System.out.println("查询部门:"+id);
        return departmentMapper.getById(id);
    }
}
