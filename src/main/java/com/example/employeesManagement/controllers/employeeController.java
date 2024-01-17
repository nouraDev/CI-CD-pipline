package com.example.employeesManagement.controllers;

import com.example.employeesManagement.models.Employee;
import com.example.employeesManagement.services.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/employee")
public class employeeController {
    public final employeeService employeeService;

    @Autowired
    public employeeController(employeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees= employeeService.findAllEmployees();
        return  new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id")  Long id){
        Employee employee= employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(Employee employee){
        Employee employee1 = employeeService.AddEmployee(employee);
        return new ResponseEntity<>(employee1,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public  ResponseEntity<Employee> updateEmployee(Employee employee){
        Employee employee1=employeeService.updateEmployee( employee);
        return  new ResponseEntity<>(employee1,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
