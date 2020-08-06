package ru.shikhovtsev.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {

  private Long id;

  private String fio;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate birthday;

  private Integer salary;

  private Long departmentId;

  public EmployeeDto(String fio, LocalDate birthday, Integer salary, Long departmentId) {
    this.fio = fio;
    this.birthday = birthday;
    this.salary = salary;
    this.departmentId = departmentId;
  }
}
