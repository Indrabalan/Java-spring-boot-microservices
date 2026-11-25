package com.app.department_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.app")
@EntityScan(basePackages = "com.app.entity")
@EnableJpaRepositories(basePackages = "com.app.repository")
public class DepartmentRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentRegistryApplication.class, args);
	}

}
