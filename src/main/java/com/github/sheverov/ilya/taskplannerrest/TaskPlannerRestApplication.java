package com.github.sheverov.ilya.taskplannerrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TaskPlannerRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskPlannerRestApplication.class, args);
	}

}
