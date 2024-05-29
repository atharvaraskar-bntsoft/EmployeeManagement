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
    public Employee savemployee(Employee employee) throws DataIsNull {
        try {
            if( employee.getName() == null || employee.getId()== 0 || employee.getSalary()==0){
                throw new DataIsNull("data is null fill all the data");
             }
             else{
                return employeedao.savemployee(employee);
             }
            
        } catch (Exception e) {
            logger.info("excption is:"+e);
        }    
           return null;
    }

    
       
      
    @Override
    public List<Employee> getallEmployees(){
        return employeedao.getAllEmployees();
    }

    @Override
    public Employee getEmployee(int id){
       
        return employeedao.getEmployee(id);
    }

    @Override
    public Employee updatEmployee(Employee employee){
        //employee.setId(id);
        return employeedao.updatEmployee(employee);
    }
     
    @Override
    public void deleteEmployee(int id) throws UserNotFound{
     try{
        if(!employeedao.getId().contains(id)){
            throw new UserNotFound("USER NOT FOUND");
        }
        else{
            employeedao.deleteEmployee(id);
        }
             }
     catch(Exception e){
            logger.info("excption is:"+e);
          }
         
    }
    
}
