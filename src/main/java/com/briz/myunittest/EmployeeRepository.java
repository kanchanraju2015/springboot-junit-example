package com.briz.myunittest;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
Optional<Employee> deleteById(int id);

Optional<Employee> findById(int i);
}
