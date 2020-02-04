package com.aditya.ems.repository;

import com.aditya.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> {


    List<Employee> findByFirstNameAndEmail(String firstName, String enail);
}
