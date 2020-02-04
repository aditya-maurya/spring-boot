package com.aditya.ems.serviceImpl;

import com.aditya.ems.model.Employee;
import com.aditya.ems.repository.EmployeeRepository;
import com.aditya.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {

        Employee employee =null;
         Optional<Employee> employeeOptional = employeeRepository.findById(id);
         if(employeeOptional.isPresent())
         {
             employee= employeeOptional.get();
         }
        return employee;

    }

    @Override
    public Employee createEmployee(Employee employee) {

        Employee employee1=null;
        if(employee!=null)
        {
          employee1=  employeeRepository.save(employee);
        }
        return employee1;
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee employee2= null;
        Employee employee1 = employeeRepository.getOne(id);
        if(employee1 !=null)
        {
            employee.setId(id);
            employee2 = employeeRepository.save(employee);
        }
        return employee2;
    }

    @Override
    public void deleteEmployeeById(int id) {

        Employee employee = employeeRepository.getOne(id);
        if(employee!=null) {
            employeeRepository.delete(employee);
        }

    }
}
