package com.sample.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.Exception.DataIsNull;
import com.sample.Exception.UserNotFound;
import com.sample.model.Employee;
import com.sample.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeservice;

    Logger logger=LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/hello")
    public String hello(){
      return "hello world";
    }
    
    @PostMapping
    public  ResponseEntity<Object>  saveemployee(@RequestBody Employee employee)throws DataIsNull{
        logger.info("The user is created",employee);

        Employee emp= employeeservice.savemployee(employee);
        
        if (emp== null) {
            return new ResponseEntity<Object>("Data is null fill all the data", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(emp, HttpStatus.OK);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        logger.info("get information of the all empoyees");
         return employeeservice.getallEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id){
        logger.info("get information of the  empoyees by id",id);
         return employeeservice.getEmployee(id);
    }

    @PutMapping
    public Employee updatEmployee(@RequestBody Employee employee){
           logger.info("update information of the  empoyee ",employee);
           return employeeservice.updatEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public  String deleteEmployee(@PathVariable("id") int id)throws UserNotFound{
        logger.info("delete  the  empoyee details ",id);
        employeeservice.deleteEmployee(id);
        return "data deleted succesfully";
    }

}
