package com.api.restapiwithjpa.controllers;

import com.api.restapiwithjpa.dto.EmployeeDto;
import com.api.restapiwithjpa.service.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private EmployeeServiceImpl employeeServiceIpml;

    //build add employee rest api
    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto saveEmployee = employeeServiceIpml.createEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeServiceIpml.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employeeDtos = employeeServiceIpml.getAllEmployee();
        return ResponseEntity.ok(employeeDtos);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employId,
                                                      @RequestBody EmployeeDto updateEmployeeDto){
        EmployeeDto employeeDto = employeeServiceIpml.updateEmployee(employId, updateEmployeeDto);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeServiceIpml.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Delete successfully!");
    }
}
