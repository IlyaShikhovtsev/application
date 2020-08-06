package ru.shikhovtsev.service;

import ru.shikhovtsev.model.EmployeeDto;

import java.util.List;

public interface EmployeeService {

  EmployeeDto get(int id);

  List<EmployeeDto> getAll();

  List<EmployeeDto> getByDepartment(int id);

  void save(EmployeeDto employee);

  void deleteById(int id);
}
