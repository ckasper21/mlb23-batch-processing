package com.kasper.mlb23batchprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Mlb23BatchProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(Mlb23BatchProcessingApplication.class, args);
	}

}
