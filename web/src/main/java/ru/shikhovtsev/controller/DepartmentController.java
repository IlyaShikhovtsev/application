package ru.shikhovtsev.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.shikhovtsev.model.DepartmentDto;
import ru.shikhovtsev.service.DepartmentService;
import ru.shikhovtsev.service.EmployeeService;

@AllArgsConstructor
@Controller
public class DepartmentController {

  private final DepartmentService departmentService;
  private final EmployeeService employeeService;

  @GetMapping(value = {"/departments", "/"})
  public String getDepartments(Model model) {
    model.addAttribute("departments", departmentService.getAll());
    return "departments";
  }

  @GetMapping(value = {"/departments/edit"})
  public String getDepartment(@RequestParam("id") int id, Model model) {
    model.addAttribute("department", departmentService.get(id));
    model.addAttribute("employees", employeeService.getByDepartment(id));
    return "edit";
  }

  @PostMapping("/departments/edit")
  public String saveDepartment(DepartmentDto department) {
    departmentService.save(department);
    return "redirect:/departments";
  }

  @GetMapping("/departments/create")
  public String createDepartment(Model model) {
    model.addAttribute("department", new DepartmentDto());
    return "edit";
  }

  @GetMapping("/departments/delete")
  public String deleteDepartment(@RequestParam("id") int id) {
    departmentService.deleteById(id);
    return "redirect:/departments";
  }
}
