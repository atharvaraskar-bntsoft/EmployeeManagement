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
    public  ResponseEntity<Object> saveEmployee(@RequestBody Employee employee){
       
        Employee emp= employeeservice.saveEmployee(employee);
        
        if (emp== null) {
            return new ResponseEntity<Object>("Data is null fill all the data", HttpStatus.BAD_REQUEST);
        }
            logger.info("The user is created",emp);
            return new ResponseEntity<Object>(emp, HttpStatus.CREATED);
       
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        logger.info("get information of the all employees");
         return employeeservice.getallEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable("id") int id){
        
        Employee employee2=employeeservice.getEmployee(id);
         if (employee2== null) {
            return  new ResponseEntity<Object>("USER NOT FOUND ",HttpStatus.NOT_FOUND);
           }
           logger.info("get information of the  employees by id",id);
           return  new ResponseEntity<Object>(employee2,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> updatEmployee(@RequestBody Employee employee){
           
           
           Employee employee2=employeeservice.updatEmployee(employee);
           if (employee2== null) {
            return  new ResponseEntity<Object>("USER NOT FOUND ",HttpStatus.NOT_FOUND);
           }
           logger.info("update information of the  employee ",employee);
           return  new ResponseEntity<Object>(employee,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id){
        

        boolean result=employeeservice.deleteEmployee(id);
         
        if(result== true){ 
              logger.info("employe deleted suucefully ",id);
              return new ResponseEntity<Object>("Data deleted succefully ",HttpStatus.OK);
        }
        else{
              return new ResponseEntity<Object>("USER NOT FOUND ",HttpStatus.NOT_FOUND);
        } 
    }

}
