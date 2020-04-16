package com.kind1ess.springboot.controller;

import com.kind1ess.springboot.entity.Employee;
import com.kind1ess.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeService.getEmp(id);
    }

    @PutMapping("/emp")
    public Employee updateEmp(Employee employee){
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable Integer id){
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/byLastName/{lastName}")
    public Employee getEmpByLastName(@PathVariable String lastName){
        return employeeService.getEmpByLastName(lastName);
    }
}
