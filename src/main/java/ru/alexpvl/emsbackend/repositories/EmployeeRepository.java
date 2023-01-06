package ru.alexpvl.emsbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.alexpvl.emsbackend.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "SELECT * FROM create_emp(:firstName, :lastName, :email)", nativeQuery = true)
	int create(String firstName, String lastName, String email);
}
