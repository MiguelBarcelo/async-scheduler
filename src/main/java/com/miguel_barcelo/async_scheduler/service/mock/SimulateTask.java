package com.miguel_barcelo.async_scheduler.service.mock;

import org.springframework.stereotype.Service;

import com.miguel_barcelo.async_scheduler.model.TaskResult;
import com.miguel_barcelo.async_scheduler.util.AppConstants;

@Service
public class SimulateTask {

	public TaskResult executeTask(String task) {
		long start = System.currentTimeMillis();
		String threadName = Thread.currentThread().getName();
		
		try {
			Thread.sleep(AppConstants.getRandomSleep(0, 3000));
			
			if (AppConstants.hasProbabilities(0.2))
				throw new RuntimeException("Something wrong happened");
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			long duration = System.currentTimeMillis() - start;
			
			return new TaskResult(task, false, duration, threadName);
		} catch (RuntimeException e) {
			long duration = System.currentTimeMillis() - start;
			
			return new TaskResult(task, false, duration, threadName);
		}
		
		long duration = System.currentTimeMillis() - start;
		
		return new TaskResult(task, true, duration, threadName);
	}
}
