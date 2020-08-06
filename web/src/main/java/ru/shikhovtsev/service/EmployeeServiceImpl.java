package ru.shikhovtsev.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.shikhovtsev.model.DepartmentDto;
import ru.shikhovtsev.model.EmployeeDto;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

  private final RestOperations rest = new RestTemplate();

  @Override
  public EmployeeDto get(int id) {
    return rest.getForObject("http://localhost:8080/core/employees/" + id, EmployeeDto.class);
  }

  @Override
  public List<EmployeeDto> getAll() {
    var request = new RequestEntity<>(HttpMethod.GET,
        UriComponentsBuilder.fromHttpUrl("http://localhost:8080")
            .path("core/employees")
            .build().toUri());

    log.info(request.getUrl().toString());

    ResponseEntity<List<EmployeeDto>> response =
        rest.exchange(request, new ParameterizedTypeReference<>() {
        });

    return response.getBody();
  }

  @Override
  public List<EmployeeDto> getByDepartment(int id) {
    var request = new RequestEntity<>(HttpMethod.GET,
        UriComponentsBuilder.fromHttpUrl("http://localhost:8080")
            .path("core/departments/" + id + "/employees")
            .build().toUri());

    log.info(request.getUrl().toString());

    ResponseEntity<List<EmployeeDto>> response =
        rest.exchange(request, new ParameterizedTypeReference<>() {
        });

    return response.getBody();
  }

  @Override
  public void save(EmployeeDto employee) {
    rest.postForEntity(UriComponentsBuilder.fromHttpUrl("http://localhost:8080/")
            .path("core/employees")
            .build().toUri(),
        employee,
        DepartmentDto.class);
  }

  @Override
  public void deleteById(int id) {
    rest.delete(UriComponentsBuilder.fromHttpUrl("http://localhost:8080/")
        .path("core/employees/" + id)
        .build().toUri());
  }
}
