package com.example.employeesManagement.DOAs;

import com.example.employeesManagement.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface employeeDOA extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);//Query method

    Optional<Employee> findEmployeeById(Long id);
}
