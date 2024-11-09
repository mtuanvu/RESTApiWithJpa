package com.api.demoapi.controllers;

import com.api.demoapi.entities.Employee;
import com.api.demoapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        try {
            Employee saveEmp = employeeService.addEmployee(employee);
            return new ResponseEntity<>(saveEmp, CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        try {
            Employee empl = employeeService.updateEmployee(id, employee);
            return new ResponseEntity<>(empl, OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){
        try {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(NO_CONTENT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getby/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(NOT_FOUND));
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }
}
