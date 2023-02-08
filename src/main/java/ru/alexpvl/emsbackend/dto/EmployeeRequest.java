package ru.alexpvl.emsbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EmployeeRequest(
	@JsonProperty("first_name")
	String firstName,
	@JsonProperty("last_name")
	String lastName,
	@JsonProperty
	String email,
	@JsonProperty("department_id")
	Integer departmentId,
	@JsonProperty("role_id")
	Integer roleId
) {}
