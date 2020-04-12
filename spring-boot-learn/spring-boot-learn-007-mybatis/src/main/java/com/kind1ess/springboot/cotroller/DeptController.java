package com.kind1ess.springboot.cotroller;


import com.kind1ess.springboot.mapper.DepartmentMapper;
import com.kind1ess.springboot.model.Department;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class DeptController {

    @Resource
    private DepartmentMapper departmentMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable Integer id){
        return departmentMapper.getDeptById(id);
    }

    @PostMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }
}
