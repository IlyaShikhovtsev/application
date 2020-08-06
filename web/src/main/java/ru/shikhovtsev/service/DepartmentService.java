package ru.shikhovtsev.service;

import ru.shikhovtsev.model.DepartmentDto;

import java.util.List;

public interface DepartmentService {

  DepartmentDto get(int id);

  List<DepartmentDto> getAll();

  void save(DepartmentDto department);

  void deleteById(int id);
}
