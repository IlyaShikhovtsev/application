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

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  private static final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);

  private final RestOperations rest = new RestTemplate();

  @Override
  public DepartmentDto get(int id) {
    return rest.getForObject("http://localhost:8080/core/departments/" + id, DepartmentDto.class);
  }

  @Override
  public List<DepartmentDto> getAll() {
    var request = new RequestEntity<>(HttpMethod.GET,
        UriComponentsBuilder.fromHttpUrl("http://localhost:8080")
            .path("core/departments")
            .build().toUri());

    log.info(request.getUrl().toString());

    ResponseEntity<List<DepartmentDto>> response =
        rest.exchange(request, new ParameterizedTypeReference<>() {
        });

    return response.getBody();
  }

  @Override
  public void save(DepartmentDto department) {
    rest.postForEntity(UriComponentsBuilder.fromHttpUrl("http://localhost:8080/")
            .path("core/departments")
            .build().toUri(),
        department,
        DepartmentDto.class);
  }

  @Override
  public void deleteById(int id) {
    rest.delete(UriComponentsBuilder.fromHttpUrl("http://localhost:8080/")
        .path("core/departments/" + id)
        .build().toUri());
  }
}
