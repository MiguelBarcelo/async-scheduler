package com.miguel_barcelo.async_scheduler.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

import com.miguel_barcelo.async_scheduler.model.TaskResult;
import com.miguel_barcelo.async_scheduler.service.mock.SimulateTask;
import com.miguel_barcelo.async_scheduler.util.AppConstants;

@Service
public class TaskExecutorService {
	
	private final ExecutorService executor;
	private final SimulateTask simulateTask;
	
	public TaskExecutorService(ExecutorService executor, SimulateTask simulateTask) {
		this.executor = executor;
		this.simulateTask = simulateTask;
	}
	
	public Map<String, TaskResult> runTasksInParallel() {
		// Parallel tasks list will be defined and executed here
		Map<String, Future<TaskResult>> scheduledTasks = new HashMap<>();
		Map<String, TaskResult> resultTasks = new HashMap<>();
		
		for (String task : AppConstants.TASKS) {
			scheduledTasks.put(task, executor.submit(() -> simulateTask.executeTask(task)));
		}
		
		for (String task : AppConstants.TASKS) {
			try {
				Future<TaskResult> future = scheduledTasks.get(task);
				resultTasks.put(task, future.get());
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} catch (ExecutionException e) {
				System.out.printf("Error %s", e.getMessage());
			}
		}			
		
		return resultTasks;
	}
}
