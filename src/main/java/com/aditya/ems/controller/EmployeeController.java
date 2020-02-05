package com.aditya.ems.controller;


import com.aditya.ems.model.Employee;
import com.aditya.ems.service.EmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployeeDetail()
    {
        return employeeService.getAllEmployees();
    }


    @GetMapping("/findById")
    public Employee findEmployeeById(@RequestParam("id") int id )
    {
        return employeeService.getEmployeeById(id);
    }


    @PostMapping("/saveEmployee")
    public Employee createEmployee(@RequestBody Employee employee)
    {
        return employeeService.createEmployee(employee);

    }

    @PutMapping("/update/{id}")
    @HystrixCommand(fallbackMethod = "errorDelayResponse", commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
    public Employee updateEmployee(@PathVariable("id") int
                                   id , @RequestBody Employee employee)
    { try {
        Thread.sleep(400000);
        return employeeService.updateEmployee(id, employee);
    }catch (InterruptedException e)
    {
        System.out.println("Data is awaiting");
    }
        return employeeService.updateEmployee(id, employee);
    }

    private Employee errorDelayResponse(@PathVariable("id") int
                                              id , @RequestBody Employee employee)
    {
        Employee employee1=new Employee();
        employee1.setId(7);
        employee1.setUserName("aaaa");
        employee1.setFirstName("AAAAA");
        employee1.setLastName("BBBBB");
        employee1.setEmail("aaa@fmaal.com");
        employee1.setSalary(344400);
       return employee1;
      //  return "Request is failed due to the taking long time";
    }



    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") int id )
    {
        employeeService.deleteEmployeeById(id);
    }

}
