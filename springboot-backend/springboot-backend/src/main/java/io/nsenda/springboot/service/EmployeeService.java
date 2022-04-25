package io.nsenda.springboot.service;

import io.nsenda.springboot.exception.ResourceNotFoundException;
import io.nsenda.springboot.model.Employee;
import java.util.List;

public interface EmployeeService
{
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id)
            throws ResourceNotFoundException;

    Employee updateEmployee(Employee employee, long id);

    void deleteEmployee(long id);
}
