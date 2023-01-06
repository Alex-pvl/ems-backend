package ru.alexpvl.emsbackend.dto;

public record EmployeeRequest(
	String firstName,
	String lastName,
	String email
) {}
