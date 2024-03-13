package com.estsoft.blogjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BlogJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogJpaApplication.class, args);
	}

}
