package com.miguel_barcelo.async_scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AsyncSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncSchedulerApplication.class, args);
	}

}
