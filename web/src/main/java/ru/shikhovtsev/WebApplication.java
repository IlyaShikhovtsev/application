package ru.shikhovtsev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {
  public static void main(String[] args) {
    SpringApplication.run(WebApplication.class);
  }
}
