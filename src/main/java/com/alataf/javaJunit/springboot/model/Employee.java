package com.alataf.javaJunit.springboot.model;

import jakarta.persistence.*;
import lombok.*;

@Setter // to create getter method using lombok annotation
@Getter // to create setter method  using lombok annotation
@AllArgsConstructor // to create constructor with all arguments using lombok annotation
@NoArgsConstructor // to create default constructor without any arguments using lombok annotation
@Builder //to create object of the Employee class using lombok annotation
@Entity // use this entity to make our Employee class as a JPA entity
@Table(name="employee") // to give table details
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable=false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

}
