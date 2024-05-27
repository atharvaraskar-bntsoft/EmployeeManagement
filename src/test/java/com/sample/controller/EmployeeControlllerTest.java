package com.sample.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.controller.EmployeeController;
import com.sample.dao.EmployeeDao;
import com.sample.model.Employee;
import com.sample.service.EmployeeServiceImpl;

import java.util.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EmployeeControlllerTest {


    @Mock
     EmployeeDao employeedao;
     
    @Mock
    EmployeeServiceImpl employeeServiceImpl ;

    @InjectMocks
    EmployeeController employeeControlller;

    @Test
    void checkhello(){
       
        String expectedresult="hello world";
        String acutalresult=employeeControlller.hello();
        assertEquals(expectedresult, acutalresult);
    }

    @Test
    void saveemployeetest(){

        Employee expected=new Employee(1,"atharva",20000);
       when(employeeServiceImpl.savemployee(expected)).thenReturn(expected);

       Employee actual=employeeControlller.saveemployee(expected);
       assertEquals(expected, actual);


    }

     @Test
    void getAllEmployees(){
            List<Employee> expectedlist =  new ArrayList<>();
            expectedlist.add(new Employee(1,"atharva",20000));
            expectedlist.add(new Employee(2,"ram",40000));

            when(employeeServiceImpl.getallEmployees()).thenReturn(expectedlist);

          //  List<Employee> actuallList=employeeControlller.saveemployee(expectedlist);
         //  assertEquals(expectedlist, actuallList);



    }
    
}
