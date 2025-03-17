package com.eucomida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaRepositories(considerNestedRepositories = true)
@EnableAsync
public class EucomidaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EucomidaApplication.class, args);
	}

}
