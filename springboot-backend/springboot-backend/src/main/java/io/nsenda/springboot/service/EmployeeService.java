package io.nsenda.springboot.service;

import io.nsenda.springboot.model.Employee;
import java.util.List;

public interface EmployeeService
{
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();
}
