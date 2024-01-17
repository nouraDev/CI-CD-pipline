package com.example.employeesManagement.services;

import com.example.employeesManagement.exceptions.UserNotFoundException;
import com.example.employeesManagement.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employeesManagement.DOAs.employeeDOA;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class employeeService {
    private final employeeDOA employeeDOA;

    @Autowired
    public employeeService(com.example.employeesManagement.DOAs.employeeDOA employeeDOA) {
        this.employeeDOA = employeeDOA;
    }
    public Employee AddEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return  employeeDOA.save(employee);
    }
    public List<Employee> findAllEmployees(){
        return employeeDOA.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeeDOA.save(employee);
    }
    public void deleteEmployee(Long id){
        employeeDOA.deleteEmployeeById(id);
    }
    public Employee findEmployeeById(Long id){
        return employeeDOA.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("not found"));
    }

}
