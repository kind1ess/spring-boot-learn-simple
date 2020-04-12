package com.kind1ess.controller;

import com.kind1ess.dao.DepartmentDao;
import com.kind1ess.dao.EmployeeDao;

import com.kind1ess.entities.Department;
import com.kind1ess.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;
    /**
     * 查询所有员工
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    /**
     * 来到添加页面
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    /**
     *添加员工
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        //回到员工列表页面
        //redirect:重定向到一个地址，/代表当前项目路径（登陆过后才能重定向）
        return "redirect:/emps";
    }

    /**
     * 查询一个员工
     * 跳转到修改页面
     */
    @GetMapping("/emp/{id}")
    public String toEditPage (@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    /**
     * 修改员工
     */
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 删除员工
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
