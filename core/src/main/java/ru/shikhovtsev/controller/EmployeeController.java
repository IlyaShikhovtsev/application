package ru.shikhovtsev.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shikhovtsev.dto.EmployeeDto;
import ru.shikhovtsev.exception.NoSuchEmployeeException;
import ru.shikhovtsev.repository.EmployeeRepository;
import ru.shikhovtsev.service.DtoServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class EmployeeController {

  private final DtoServiceImpl dtoService;
  private final EmployeeRepository employeeRepository;

  @GetMapping("/employees")
  public List<EmployeeDto> get() {
    return employeeRepository.findAll()
        .stream().map(dtoService::toDto).collect(Collectors.toList());
  }

  @GetMapping("/employees/{id}")
  public EmployeeDto get(@PathVariable Long id) {
    return employeeRepository.findById(id).map(dtoService::toDto).orElseThrow(() -> new NoSuchEmployeeException("No employee with id " + id));
  }

  @PostMapping("/employees")
  public EmployeeDto save(@RequestBody EmployeeDto employee) {
    return dtoService.toDto(employeeRepository.save(dtoService.toDomainObject(employee)));
  }

  @DeleteMapping("/employees/{id}")
  public void delete(@PathVariable Long id) {
    employeeRepository.deleteById(id);
  }
}
