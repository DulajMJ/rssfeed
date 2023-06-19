package com.assignment.rssfeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RssfeedApplication {

	public static void main(String[] args) {

		SpringApplication.run(RssfeedApplication.class, args);
	}

}
