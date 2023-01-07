package ru.alexpvl.emsbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alexpvl.emsbackend.dto.EmployeeDTO;
import ru.alexpvl.emsbackend.dto.EmployeeRequest;
import ru.alexpvl.emsbackend.exceptions.ApiException.EmployeeNotFound;
import ru.alexpvl.emsbackend.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<EmployeeDTO> getEmployees() throws EmployeeNotFound {
		return employeeService.getAll();
	}

	@GetMapping("/{employeeId}")
	public EmployeeDTO getEmployee(
		@PathVariable Long employeeId
	) throws EmployeeNotFound {
		return employeeService.getEmployee(employeeId);
	}

	@PostMapping
	public EmployeeDTO createEmployee(
		@RequestBody EmployeeRequest request
	) {
		return employeeService.createEmployee(request);
	}

	@PutMapping("/{employeeId}")
	public void updateEmployee(
		@PathVariable Long employeeId,
		@RequestBody EmployeeRequest request
	) throws EmployeeNotFound {
		employeeService.updateEmployee(employeeId, request);
	}

	@DeleteMapping("/{employeeId}")
	public void deleteEmployee(
		@PathVariable Long employeeId
	) throws EmployeeNotFound {
		employeeService.deleteEmployee(employeeId);
	}
}
