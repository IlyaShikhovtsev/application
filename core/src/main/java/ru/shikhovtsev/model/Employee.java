package ru.shikhovtsev.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "fio")
  private String fio;

  @Column(name = "birthday")
  private LocalDate birthday;

  @Column(name = "salary")
  private Integer salary;

  @JsonIgnore
  @ManyToOne
  private Department department;

  public Employee(String fio, LocalDate birthday, Integer salary, Department department) {
    this.fio = fio;
    this.birthday = birthday;
    this.salary = salary;
    this.department = department;
  }

  public Employee(Long id, String fio, LocalDate birthday, Integer salary, Department department) {
    this.id = id;
    this.fio = fio;
    this.birthday = birthday;
    this.salary = salary;
    this.department = department;
  }
}
