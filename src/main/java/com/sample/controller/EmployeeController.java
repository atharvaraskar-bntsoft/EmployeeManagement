package com.sample.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.Employee;
import com.sample.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeservice;
    
    @PostMapping
    public Employee saveemployee(@RequestBody Employee employee){
        return employeeservice.savemployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
         return employeeservice.getallEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") int id){
         return employeeservice.getEmployee(id);
    }

    @PutMapping
    public Employee updatEmployee(@RequestBody Employee employee){
           return employeeservice.updatEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public  String deleteEmployee(@PathVariable("id") int id){
        employeeservice.deleteEmployee(id);
        return "data deleted succesfully";
    }

   
    
}
