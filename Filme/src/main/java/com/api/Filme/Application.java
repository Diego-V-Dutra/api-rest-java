package com.api.Filme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("model")
@ComponentScan(basePackages = {"controllers"})
@EnableJpaRepositories("repositories")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
