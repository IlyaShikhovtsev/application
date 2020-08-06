package ru.shikhovtsev.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.shikhovtsev.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
