package ru.alexpvl.emsbackend.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public abstract class ApiException extends RuntimeException {

	@Message("Employee #{employeeId} not found")
	@AllArgsConstructor
	public static class EmployeeNotFound extends ApiException {
		public final Long employeeId;
	}

	public @interface Message {
		String value();
	}
}
