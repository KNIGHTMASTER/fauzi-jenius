package com.wissensalt.fj.api.logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//@EnableEurekaClient
@EnableMongoRepositories
@SpringBootApplication
public class FJLoggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FJLoggerApplication.class, args);
	}
}
