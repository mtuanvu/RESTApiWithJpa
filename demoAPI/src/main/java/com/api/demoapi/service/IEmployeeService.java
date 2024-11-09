package com.api.demoapi.service;

import com.api.demoapi.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Employee addEmployee(Employee employee);
    Employee updateEmployee(int id, Employee employee);
    Employee deleteEmployee(int id);
    Optional<Employee> getEmployeeById(int id);
    List<Employee> getAllEmployees();
}
