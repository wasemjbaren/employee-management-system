package com.example.employee_management_system.dto;

import jakarta.validation.constraints.*;

public class EmployeeCreateDto {

    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 50)
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String position;

    @NotNull
    @DecimalMin(value = "5500.0", inclusive = true)
    @DecimalMax(value = "100000.0", inclusive = true)
    private Double salary;

    @NotBlank
    private String department;

    public EmployeeCreateDto() {}

    public EmployeeCreateDto(String firstName, String lastName, String email, String position, Double salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.position = position;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }


}