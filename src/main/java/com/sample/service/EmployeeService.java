package com.sample.service;

import java.util.List;



import com.sample.model.Employee;

public interface EmployeeService {
    
     public Employee saveEmployee(Employee employee) ;

     public Employee getEmployee(int id);

     public List<Employee> getallEmployees();
  
     public Employee updatEmployee(Employee employee);

     public boolean deleteEmployee(int id) ;

  } 
