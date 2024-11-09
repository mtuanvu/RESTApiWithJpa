package com.api.demoapi.service;

import com.api.demoapi.entities.Employee;
import com.api.demoapi.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if(employee == null){
            throw new IllegalArgumentException("Employee cannot be null");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
        existingEmployee.setFullName(employee.getFullName());
        existingEmployee.setDateOfBirth(employee.getDateOfBirth());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setEmail(employee.getEmail());

        return employeeRepository.save(existingEmployee);
    }

    @Override
    public Employee deleteEmployee(int id) {
        if (employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Employee not found with id: " + id);
        }
        return null;
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
