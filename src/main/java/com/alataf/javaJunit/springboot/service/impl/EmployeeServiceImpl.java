package com.alataf.javaJunit.springboot.service.impl;

import com.alataf.javaJunit.springboot.exception.ResourceNotFoundException;
import com.alataf.javaJunit.springboot.model.Employee;
import com.alataf.javaJunit.springboot.repository.EmployeeRepository;
import com.alataf.javaJunit.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository; //injected dependency

    @Override
    public Employee saveEmployee(Employee employee) {

        Optional<Employee> savedEmployee = employeeRepository.findqByEmail(employee.getEmail());
        if(savedEmployee.isPresent()){
            throw new ResourceNotFoundException("Employee already exist with given email:" + employee.getemail());
        }

        return employeeRepository.save(employee);
    }
}
