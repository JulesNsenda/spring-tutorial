package io.nsenda.springboot.service.impl;

import io.nsenda.springboot.exception.ResourceNotFoundException;
import io.nsenda.springboot.model.Employee;
import io.nsenda.springboot.repository.EmployeeRepository;
import io.nsenda.springboot.service.EmployeeService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl
        implements EmployeeService
{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id)
            throws ResourceNotFoundException
    {
        Optional<Employee> emp = employeeRepository.findById(id);
        return emp.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }
}
