/* Layer 3 -> Repository or DAO layer
 *
 * Represents the tables in physical DB
 */

package com.shiva.employermanagementrestAPI.restapi.repository;

import com.shiva.employermanagementrestAPI.restapi.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

