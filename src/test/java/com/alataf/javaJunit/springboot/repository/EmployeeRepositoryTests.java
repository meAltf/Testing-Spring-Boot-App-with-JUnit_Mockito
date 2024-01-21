package com.alataf.javaJunit.springboot.repository;

import com.alataf.javaJunit.springboot.model.Employee;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Junit test for save employee operation
    //@DisplayName("Junit test for save employee operation")
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSaveEmployee(){

        //given- precondition or setup
        Employee employee = Employee.builder()
                .firstName("alataf")
                .lastName("wyatt")
                .email("alataf@google.com")
                .build();

        //when-action or the behaviour that we are going to test
        Employee savedEmployee = employeeRepository.save(employee);

        //then-verify the output
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }
}
