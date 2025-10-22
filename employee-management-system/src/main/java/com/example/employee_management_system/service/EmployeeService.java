package com.example.employee_management_system.service;

import com.example.employee_management_system.dto.EmployeeCreateDto;
import com.example.employee_management_system.dto.EmployeeResponseDto;
import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.exception.DuplicateEmailException;
import com.example.employee_management_system.exception.EmployeeNotFoundException;
import com.example.employee_management_system.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public EmployeeResponseDto createEmployee(EmployeeCreateDto dto) {
        if (repository.existsByEmail(dto.getEmail())) {
            throw new DuplicateEmailException("Email already exists: " + dto.getEmail());
        }
        Employee employee = new Employee(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPosition(),
                dto.getSalary(),
                dto.getDepartment()
        );
        repository.save(employee);
        return new EmployeeResponseDto(employee);
    }

    public List<EmployeeResponseDto> getAllEmployees() {
        List<Employee> employees = repository.findAll();
        List<EmployeeResponseDto> responseList = new ArrayList<>();

        for (Employee emp : employees) {
            EmployeeResponseDto dto = new EmployeeResponseDto(emp);
            responseList.add(dto);
        }

        return responseList;
    }


    public EmployeeResponseDto getEmployeeById(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        return new EmployeeResponseDto(employee);
    }

    public EmployeeResponseDto updateEmployee(Long id, EmployeeCreateDto dto) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

        String currentEmail = employee.getEmail();
        String newEmail = dto.getEmail();


        boolean isEmailChanged = !currentEmail.equals(newEmail);
        boolean isEmailDuplicate = repository.existsByEmail(newEmail);

        if (isEmailChanged && isEmailDuplicate) {
            throw new DuplicateEmailException("Email already exists: " + newEmail);
        }

        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setPosition(dto.getPosition());
        employee.setSalary(dto.getSalary());
        employee.setDepartment(dto.getDepartment());

        repository.save(employee);
        return new EmployeeResponseDto(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        repository.delete(employee);
    }
}

