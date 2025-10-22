package com.example.employee_management_system.dto;

import com.example.employee_management_system.entity.Employee;

public class EmployeeResponseDto {
    private Long id;
    private String fullName;
    private String email;
    private String position;
    private Double salary;
    private String department;

    public EmployeeResponseDto(Employee employee) {
        this.id = employee.getId();
        this.fullName = employee.getFirstName() + " " + employee.getLastName();
        this.email = employee.getEmail();
        this.position = employee.getPosition();
        this.salary = employee.getSalary();
        this.department = employee.getDepartment();
    }

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPosition() { return position; }
    public Double getSalary() { return salary; }
    public String getDepartment() { return department; }
}


