package ru.alexpvl.emsbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexpvl.emsbackend.dto.EmployeeRequest;
import ru.alexpvl.emsbackend.exceptions.ApiException;
import ru.alexpvl.emsbackend.models.Employee;
import ru.alexpvl.emsbackend.repositories.EmployeeRepository;

import java.util.List;
import java.util.function.Function;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional(readOnly = true)
	public <T> List<T> getAll(Function<Employee, T> mapper) {
		return getAll().stream().map(mapper).toList();
	}

	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public Employee getEmployee(Long id) {
		return employeeRepository.findById(id)
			.orElseThrow(() -> new ApiException.EmployeeNotFound(id));
	}

	public Employee createEmployee(EmployeeRequest request) {
		var employeeId = employeeRepository.create(
			request.firstName(),
			request.lastName(),
			request.email(),
			request.departmentId(),
			request.roleId()
		);

		return getEmployee((long) employeeId);
	}

	public void updateEmployee(Long id, EmployeeRequest request) {
		employeeRepository.update(
			id.intValue(),
			request.firstName(),
			request.lastName(),
			request.email(),
			request.departmentId(),
			request.roleId()
		);
	}

	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
}
