package com.example.employee_management_system.exception;

public class EmployeeNotFoundException extends RuntimeException{
     public EmployeeNotFoundException(String message) {
         super(message);
     }
}
