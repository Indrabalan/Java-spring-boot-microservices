package com.app.student_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.app.student")
@EnableFeignClients(basePackages = "com.app.student.feign")
@EntityScan(basePackages = "com.app.student.entity")
@EnableJpaRepositories(basePackages = "com.app.student.repository")
public class StudentRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRegistryApplication.class, args);
	}
}