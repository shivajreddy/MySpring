/* Layer 2 -> Service layer
 *
 * All the
 * Represents the tables in physical DB
 */
package com.shiva.employermanagementrestAPI.restapi.service;

import com.shiva.employermanagementrestAPI.restapi.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Optional<Employee> getEmployeeById(Long id);

    public Employee saveEmployee(Employee employee);

}
