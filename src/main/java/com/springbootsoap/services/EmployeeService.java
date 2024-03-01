package com.springbootsoap.services;

import com.springbootsoap.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface EmployeeService {

    void AddEmployee(Employee employee);

    Employee getEmployById(long employeeId);

    void updateEmployee(Employee employee);

    void deleteEmployee(long employeeId);
}
