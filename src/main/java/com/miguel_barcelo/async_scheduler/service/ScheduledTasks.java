package com.miguel_barcelo.async_scheduler.service;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.miguel_barcelo.async_scheduler.model.TaskResult;

@Service
public class ScheduledTasks {

	private final TaskExecutorService service;
	
	public ScheduledTasks(TaskExecutorService service) {
		this.service = service;
	}
	
	@Scheduled(fixedRate = 10000) // Every 10 secs
	public void runScheduledTasks() {
		//Concurrent tasks will be activated here
		Map<String, TaskResult> results = service.runTasksInParallel();
		printResults(results);
	}
	
	private void printResults(Map<String, TaskResult> resultTasks) {
		System.out.println(String.format("=== Scheduler results at %s===", LocalDateTime.now()));
		for (TaskResult result: resultTasks.values()) {
			System.out.printf("🔧 Task: %s\t | ✅ Success: %s\t | ⏱️ Duration: %d ms\t | 🧵 Thread: %s\n", 
				result.getTaskName(), result.isSuccess(), result.getDurationMillis(), result.getThreadName()	
			);			
		}
		System.out.println();
	}
}
