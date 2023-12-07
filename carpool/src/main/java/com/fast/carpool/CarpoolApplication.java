package com.fast.carpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"model","Repository","Service","Controller"})
@EnableJpaRepositories(basePackages ="Repository")
@EntityScan("model")
@SpringBootApplication
public class CarpoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarpoolApplication.class, args);
	}

}

