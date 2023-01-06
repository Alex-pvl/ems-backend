package ru.alexpvl.emsbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexpvl.emsbackend.dto.EmployeeDTO;
import ru.alexpvl.emsbackend.dto.EmployeeRequest;
import ru.alexpvl.emsbackend.exceptions.ApiException;
import ru.alexpvl.emsbackend.repositories.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeeDTO> getAll() {
		var employees = employeeRepository.findAll();
		return employees.stream().map(EmployeeDTO::new).toList();
	}

	public EmployeeDTO getEmployee(Long id) {
		var employee = employeeRepository.findById(id)
			.orElseThrow(() -> new ApiException.EmployeeNotFound(id));
		return new EmployeeDTO(employee);
	}

	@Transactional
	public EmployeeDTO createEmployee(EmployeeRequest request) {
		var employeeId = employeeRepository.create(
			request.firstName(),
			request.lastName(),
			request.email()
		);

		return getEmployee((long) employeeId);
	}
}
