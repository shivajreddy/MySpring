/* Entity that represents the Employee table in DB
 *
 */

package com.shiva.employermanagementrestAPI.restapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "firstName can't be blank")
    @Column(name = "firstName")
    private String firstName;

    @NotBlank(message = "lastName can't be blank")
    @Column(name = "lastName")
    private String lastName;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

