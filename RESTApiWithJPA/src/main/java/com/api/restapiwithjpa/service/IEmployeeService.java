package com.api.restapiwithjpa.service;

import com.api.restapiwithjpa.dto.EmployeeDto;

import java.util.List;

public interface IEmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee);
    void deleteEmployee(Long employeeId);
}
