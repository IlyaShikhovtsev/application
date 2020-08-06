package ru.shikhovtsev.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shikhovtsev.model.Department;
import ru.shikhovtsev.model.Employee;
import ru.shikhovtsev.repository.DepartmentRepository;
import ru.shikhovtsev.repository.EmployeeRepository;

import java.util.List;

@AllArgsConstructor
@RestController
public class DepartmentController {

  private final DepartmentRepository departmentRepository;
  private final EmployeeRepository employeeRepository;

  @GetMapping("/departments")
  public List<Department> get() {
    return departmentRepository.findAll();
  }

  @GetMapping("/departments/{id}")
  public Department get(@PathVariable Long id) {
    return departmentRepository.findById(id).orElse(null);
  }

  @PostMapping("/departments")
  public Department save(@RequestBody Department department) {
    return departmentRepository.save(department);
  }

  @GetMapping("/departments/{id}/employees")
  public List<Employee> getEmployees(@PathVariable Long id) {
    return employeeRepository.findAllByDepartmentId(id);
  }

  @DeleteMapping("/departments/{id}")
  public void delete(@PathVariable Long id) {
    departmentRepository.deleteById(id);
  }
}
