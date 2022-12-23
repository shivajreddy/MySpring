/* Layer 2 -> Service layer Implementation
 */
package com.shiva.employermanagementrestAPI.restapi.service;

import java.util.List;
import java.util.Optional;

import com.shiva.employermanagementrestAPI.restapi.model.Employee;
import com.shiva.employermanagementrestAPI.restapi.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    // inject repository dependency
    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }


}
