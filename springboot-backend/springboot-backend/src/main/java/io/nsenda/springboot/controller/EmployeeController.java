package io.nsenda.springboot.controller;

import io.nsenda.springboot.model.Employee;
import io.nsenda.springboot.service.EmployeeService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController
{
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> saveEmployee(@RequestBody @NonNull Employee employee)
    {
        Employee emp = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") @NonNull long id)
    {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") @NonNull long id, @RequestBody @NonNull Employee employee)
    {
        return new ResponseEntity<>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") @NonNull long id)
    {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }
}
