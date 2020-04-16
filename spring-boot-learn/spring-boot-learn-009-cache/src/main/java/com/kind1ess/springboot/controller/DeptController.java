package com.kind1ess.springboot.controller;


import com.kind1ess.springboot.entity.Department;
import com.kind1ess.springboot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department getById(@PathVariable Integer id){
        return deptService.getById(id);
    }
}
