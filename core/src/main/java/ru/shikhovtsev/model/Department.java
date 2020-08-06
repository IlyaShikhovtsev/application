package ru.shikhovtsev.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "department")
  private List<Employee> employees;

  public Department(String name) {
    this.name = name;
  }
}
