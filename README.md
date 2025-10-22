# Employee Management System

**Description:**  
Employee Management System with full CRUD, validation, and exception handling.

---

## Features

- Create, Read, Update, Delete (CRUD) employees
- DTO validation (`@NotBlank`, `@Size`, `@Email`, `@DecimalMin`, etc.)
- Custom exceptions:
  - `EmployeeNotFoundException` (404 Not Found)
  - `DuplicateEmailException` (409 Conflict)
- Global exception handling for clean API responses
- RESTful API endpoints:
  - `POST /employees` – Create employee
  - `GET /employees` – Get all employees
  - `GET /employees/{id}` – Get employee by ID
  - `PUT /employees/{id}` – Update employee
  - `DELETE /employees/{id}` – Delete employee

---

## Technologies

- Spring Boot
- Spring Data JPA
- Hibernate Validator
- H2 Database

---

## Setup

1. Clone the repository:  

git clone <your-repo-url>
Navigate to the project folder:


cd employee-management-system
Run the application:


./mvnw spring-boot:run

Access the API at:

http://localhost:8080/employees
