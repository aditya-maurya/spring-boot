package com.aditya.ems.service;

import com.aditya.ems.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(int id);
    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(int id , Employee employee);
    public void deleteEmployeeById(int id);

}
