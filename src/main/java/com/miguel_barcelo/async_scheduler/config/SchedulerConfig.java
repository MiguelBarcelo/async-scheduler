package com.miguel_barcelo.async_scheduler.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

	@Bean
	ExecutorService taskExecutor() {
		return Executors.newFixedThreadPool(5);
	}
}
