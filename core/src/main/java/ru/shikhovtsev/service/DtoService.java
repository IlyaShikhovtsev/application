package ru.shikhovtsev.service;

import ru.shikhovtsev.dto.EmployeeDto;
import ru.shikhovtsev.model.Employee;

public interface DtoService {
  Employee toDomainObject(EmployeeDto dto);

  EmployeeDto toDto(Employee employee);
}
