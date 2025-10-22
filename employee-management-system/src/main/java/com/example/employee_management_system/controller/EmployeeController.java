package com.example.employee_management_system.controller;
import com.example.employee_management_system.dto.EmployeeCreateDto;
import com.example.employee_management_system.dto.EmployeeResponseDto;
import com.example.employee_management_system.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponseDto createEmployee(@Valid @RequestBody EmployeeCreateDto dto) {
        return service.createEmployee(dto);
    }

    @GetMapping
    public List<EmployeeResponseDto> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeResponseDto getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDto updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeCreateDto dto) {
        return service.updateEmployee(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
    }

}
