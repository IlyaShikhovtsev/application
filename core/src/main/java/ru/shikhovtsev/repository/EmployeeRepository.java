package ru.shikhovtsev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shikhovtsev.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  List<Employee> findAllByDepartmentId(Long id);
}
