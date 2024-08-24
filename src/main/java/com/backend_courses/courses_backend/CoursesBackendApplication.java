package com.backend_courses.courses_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// @SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CoursesBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursesBackendApplication.class, args);
	}

}
