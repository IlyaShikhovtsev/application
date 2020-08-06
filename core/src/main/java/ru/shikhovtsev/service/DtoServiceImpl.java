package ru.shikhovtsev.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shikhovtsev.dto.EmployeeDto;
import ru.shikhovtsev.exception.NoSuchDepartmentException;
import ru.shikhovtsev.model.Department;
import ru.shikhovtsev.model.Employee;
import ru.shikhovtsev.repository.DepartmentRepository;

@Service
@AllArgsConstructor
public class DtoServiceImpl implements DtoService {

  private final DepartmentRepository departmentRepository;

  @Override
  public Employee toDomainObject(EmployeeDto dto) {
    Department department = departmentRepository.findById(dto.getDepartmentId()).orElseThrow(() -> new NoSuchDepartmentException("There is no department with id" + dto.getDepartmentId()));
    return new Employee(dto.getId(), dto.getFio(), dto.getBirthday(), dto.getSalary(), department);
  }

  @Override
  public EmployeeDto toDto(Employee employee) {
    return new EmployeeDto(employee.getId(), employee.getFio(), employee.getBirthday(), employee.getSalary(), employee.getDepartment().getId());
  }
}
