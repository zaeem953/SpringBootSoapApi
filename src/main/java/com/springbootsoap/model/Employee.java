package com.springbootsoap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Employee{

    @Id
    private Long employeeId;

    private String name;

    private String department;

    private String phone;

    private String address;
}
