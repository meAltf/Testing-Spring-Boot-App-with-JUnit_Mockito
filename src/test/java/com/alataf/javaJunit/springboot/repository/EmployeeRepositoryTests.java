package com.alataf.javaJunit.springboot.repository;

import com.alataf.javaJunit.springboot.model.Employee;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

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

    //JUnit test for get all employee operation
    @Test
    public void givenEmployeesList_whenFindAll_thenEmployeeList(){
        //given- precondition or setup
        Employee employee = Employee.builder()
                .firstName("alataf")
                .lastName("wyatt")
                .email("alataf@google.com")
                .build();

        Employee employee1 = Employee.builder()
                .firstName("alataf")
                .lastName("wyatt")
                .email("alataf@google.com")
                .build();

        employeeRepository.save(employee);
        employeeRepository.save(employee1);

        //when-action or the behaviour that we are going to test
        List<Employee> employeeList = employeeRepository.findAll();

        //then-verify the output
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);
    }

    //JUnit test for get employee by id operation
        @Test
        public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject(){
            //given- precondition or setup
            Employee employee = Employee.builder()
                    .firstName("alataf")
                    .lastName("wyatt")
                    .email("alataf@google.com")
                    .build();
            employeeRepository.save(employee);

            //when-action or the behaviour that we are going to test
            Employee employeeDB = employeeRepository.findAllById(employee.getId());

            //then-verify the output
            assertThat(employeeDB).isNotNull();
        }
    //JUnit test for get employee by email operation
        @Test
        public void givenEmployeeEmail_whenFindByEmail_thenReturnEmployeeObject(){

            //given- precondition or setup
            Employee employee = Employee.builder()
                    .firstName("alataf")
                    .lastName("wyatt")
                    .email("alataf@google.com")
                    .build();
            employeeRepository.save(employee);

            //when-action or the behaviour that we are going to test
            Employee employeeDB = employeeRepository.findqByEmail(employee.getEmail()).get();

            //then-verify the output
            assertThat(employeeDB).isNotNull();
        }
}
