package ru.alexpvl.emsbackend.dto;

import lombok.Data;
import ru.alexpvl.emsbackend.models.Employee;

@Data
public class EmployeeDTO {
	private final String firstName;
	private final String lastName;
	private final String email;
	private final String department;
	private final String role;

	public EmployeeDTO(Employee employee) {
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.email = employee.getEmail();
		this.department = employee.getDepartment().getName();
		this.role = employee.getRole().getName();
	}
}
