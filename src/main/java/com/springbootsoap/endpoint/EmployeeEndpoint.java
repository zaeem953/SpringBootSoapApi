package com.springbootsoap.endpoint;

import allapis.springbootsoap.com.*;
import com.springbootsoap.model.Employee;
import com.springbootsoap.services.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeeEndpoint {

    private static final String NAMESPACE_URI="http://com.springbootsoap.allapis";

    @Autowired
    private EmployeeService employeeService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
    @ResponsePayload
    public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request){
        AddEmployeeResponse response=new AddEmployeeResponse();
        ServiceStatus serviceStatus=new ServiceStatus();

        Employee employee=new Employee();
        BeanUtils.copyProperties(request.getEmployeeInfo(),employee);
        employeeService.AddEmployee(employee);
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Added Seccessfully");
        response.setServiceStatus(serviceStatus);
        response.setEmployeeInfo(request.getEmployeeInfo());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
    @ResponsePayload
    public GetEmployeeByIdResponse getEmployee(@RequestPayload GetEmployeeByIdRequest request){
        GetEmployeeByIdResponse response=new GetEmployeeByIdResponse();
        EmployeeInfo employeeInfo=new EmployeeInfo();
        BeanUtils.copyProperties(employeeService.getEmployById(request.getEmployeeId()),employeeInfo);
        response.setEmployeeInfo(employeeInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
    @ResponsePayload
    public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request){
        Employee employee=new Employee();
        BeanUtils.copyProperties(request.getEmployeeInfo(),employee);
        employeeService.updateEmployee(employee);
        ServiceStatus serviceStatus=new ServiceStatus();
        UpdateEmployeeResponse response=new UpdateEmployeeResponse();
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Updated Seccessfully");
        response.setServiceStatus(serviceStatus);
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
    @ResponsePayload
    public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request){
        employeeService.deleteEmployee(request.getEmployeeId());
        DeleteEmployeeResponse response=new DeleteEmployeeResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Deleted Seccessfully");
        response.setServiceStatus(serviceStatus);
        return response;
    }
}
