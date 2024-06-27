package com.picpaybackend.picpaybackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@OpenAPIDefinition(info = @Info(title = "Desafio Backend Api", version= "1", description = "Api para trasação"))
//Link Swagger => http://localhost:8080/swagger-ui/index.html#/
@EnableScheduling

@SpringBootApplication
public class PicpaybackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicpaybackendApplication.class, args);
	}

}
