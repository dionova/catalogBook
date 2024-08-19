package com.example.catalogBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class CatalogBookApplication {
	public static void main(String[] args) {
		SpringApplication.run(CatalogBookApplication.class, args);
	}

}
