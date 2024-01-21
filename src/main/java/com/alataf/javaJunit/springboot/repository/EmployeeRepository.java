package com.alataf.javaJunit.springboot.repository;

import com.alataf.javaJunit.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findqByEmail(String email);
}
