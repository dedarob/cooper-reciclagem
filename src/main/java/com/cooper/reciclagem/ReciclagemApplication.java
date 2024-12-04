package com.cooper.reciclagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class ReciclagemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReciclagemApplication.class, args);
	}

}
