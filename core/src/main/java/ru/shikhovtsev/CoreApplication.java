package ru.shikhovtsev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import ru.shikhovtsev.model.Department;
import ru.shikhovtsev.model.Employee;
import ru.shikhovtsev.repository.DepartmentRepository;
import ru.shikhovtsev.repository.EmployeeRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class CoreApplication extends SpringBootServletInitializer {

  @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
  @Autowired
  private DepartmentRepository departmentRepository;
  //Исключительно для примера
  @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
  @Autowired
  private EmployeeRepository employeeRepository;

  public static void main(String[] args) {
    SpringApplication.run(CoreApplication.class);
  }

  @PostConstruct
  public void init() {
    Department firstDep = departmentRepository.save(new Department("First Dep"));
    Department secondDep = departmentRepository.save(new Department("Second Dep"));
    Department thirdDep = departmentRepository.save(new Department("Third Dep"));
    departmentRepository.save(new Department("Fourth Dep"));

    employeeRepository.save(new Employee("Ilya Sergeevich Shikhovtsev", LocalDate.of(1997, 5, 15), 10, firstDep));
    employeeRepository.save(new Employee("Dmitry Sergeevich Shikhovtsev", LocalDate.of(1997, 5, 15), 52, firstDep));
    employeeRepository.save(new Employee("Fedor Sergeevich Stennikov", LocalDate.of(1997, 12, 21), 62, secondDep));
    employeeRepository.save(new Employee("Marina Sergeevna Shikhovtseva", LocalDate.of(1988, 2, 12), 10, secondDep));
    employeeRepository.save(new Employee("Nastya Sergeevna Shikhovtseva", LocalDate.of(2010, 1, 7), 16, thirdDep));
    employeeRepository.save(new Employee("Larisa Sergeevna Shikhovtseva", LocalDate.of(2000, 3, 17), 40, thirdDep));
    employeeRepository.save(new Employee("Anya Sergeevna Shikhovtseva", LocalDate.of(1965, 4, 28), 18, thirdDep));
  }
}
