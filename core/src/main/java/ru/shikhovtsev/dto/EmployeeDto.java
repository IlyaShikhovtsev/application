package ru.shikhovtsev.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {

  private Long id;

  private String fio;

  private LocalDate birthday;

  private Integer salary;

  private Long departmentId;

  public EmployeeDto(Long id, String fio, LocalDate birthday, Integer salary, Long departmentId) {
    this.id = id;
    this.fio = fio;
    this.birthday = birthday;
    this.salary = salary;
    this.departmentId = departmentId;
  }


}
