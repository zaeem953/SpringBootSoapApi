package com.springbootsoap.services;


import com.springbootsoap.model.Employee;
import com.springbootsoap.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public void AddEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployById(long employeeId) {
        Employee employee=employeeRepository.findByEmployeeId(employeeId);
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
