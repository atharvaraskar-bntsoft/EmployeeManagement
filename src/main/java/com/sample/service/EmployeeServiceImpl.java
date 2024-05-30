package com.sample.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.EmployeeDao;
import com.sample.model.Employee;
import com.sample.Exception.DataIsNull;
import com.sample.Exception.UserNotFound;


@Service
public class EmployeeServiceImpl implements EmployeeService{
     
    @Autowired
    EmployeeDao employeedao;

    Logger logger=LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public Employee saveEmployee(Employee employee)  {
        Employee employee2=null;
        try {
            if( employee.getName() == null || employee.getId()== 0 || employee.getSalary()==0
                     || employeedao.GetListOfAllId().contains(employee.getId() )   ){                               
                throw new DataIsNull("data is null fill all the data");
             }
                employee2=employeedao.saveEmployee(employee);
                return employee2;
            
        } catch (Exception e) {
            logger.error("excption is:"+e);
        }    
           return employee2;
    }

    
       
      
    @Override
    public List<Employee> getallEmployees(){
        return employeedao.getAllEmployees();
    }

    @Override
    public Employee getEmployee(int id){
        Employee employee2=null;
        try{
            if(!employeedao.GetListOfAllId().contains(id)){ 
        
                 throw new UserNotFound("USER NOT FOUND");
            }
            else{
                employee2= employeedao.getEmployee(id);
                return employee2;
            }
                 }
         catch(Exception e){
                logger.error("excption is:"+e);
                return  employee2; 
              }
       

    }

    @Override
    public Employee updatEmployee(Employee employee){
        Employee employee2=null;
        try{
            if(!employeedao.GetListOfAllId().contains(employee.getId() )){ 
        
                 throw new UserNotFound("USER NOT FOUND");
            }
            else{
                employee2= employeedao.updatEmployee(employee);
                return employee2;
            }
                 }
         catch(Exception e){
                logger.error("excption is:"+e);
                return  employee2; 
              }
       
    }
     

    @Override
    public boolean deleteEmployee(int id) {
    
     try{
        if(!employeedao.GetListOfAllId().contains(id)){ 
    
             throw new UserNotFound("USER NOT FOUND");
        }
        else{
            employeedao.deleteEmployee(id);
            return true;
        }
             }
     catch(Exception e){
            logger.error("excption is:"+e);
            return false; 
          }
     //   return false;      
    }
    
}
