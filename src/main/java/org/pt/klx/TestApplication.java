package org.pt.klx;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "KLX Test API", version = "1.0", description = "KLX Test Documentation"))
public class TestApplication {

  public static void main(final String[] args) {
    SpringApplication.run(TestApplication.class, args);
  }

}
