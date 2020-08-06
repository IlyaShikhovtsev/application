package ru.shikhovtsev.controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.shikhovtsev.model.EmployeeDto;
import ru.shikhovtsev.service.DepartmentService;
import ru.shikhovtsev.service.EmployeeService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Controller
public class EmployeeController {

  private final EmployeeService employeeService;
  private final DepartmentService departmentService;

  @GetMapping(value = {"/employees/edit"})
  public String getEmployee(@RequestParam("id") int id, Model model) {
    model.addAttribute("employee", employeeService.get(id));
    model.addAttribute("departments", departmentService.getAll());
    return "editEmployee";
  }

  @PostMapping("/employees/edit")
  public String saveEmployee(EmployeeDto employee) {
    employeeService.save(employee);
    return "redirect:/departments";
  }

  @GetMapping("/employees/create")
  public String create(Model model) {
    model.addAttribute("employee", new EmployeeDto());
    model.addAttribute("departments", departmentService.getAll());
    return "editEmployee";
  }

  @GetMapping(value = "/employees")
  public String getEmployees(Model model) {
    List<EmployeeDto> employees = employeeService.getAll();

    model.addAttribute("employees", employees);
    return "employees";
  }

  @PostMapping(value = "/employees")
  public String getEmployeesFiltered(
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
      Model model) {
    List<EmployeeDto> employees;

    if (from != null && to != null) {
      employees = employeeService.getAll().stream()
          .filter(e -> !(e.getBirthday().isBefore(from) || e.getBirthday().isAfter(to)))
          .collect(Collectors.toList());
    } else if (from != null) {
      employees = employeeService.getAll().stream()
          .filter(e -> e.getBirthday().equals(from))
          .collect(Collectors.toList());
    } else {
      employees = employeeService.getAll();
    }

    model.addAttribute("employees", employees);
    model.addAttribute("from", from);
    model.addAttribute("to", to);
    return "employees";
  }

  @GetMapping("/employees/delete")
  public String saveEmployee(@RequestParam("id") int id) {
    employeeService.deleteById(id);
    return "redirect:/employees";
  }
}
