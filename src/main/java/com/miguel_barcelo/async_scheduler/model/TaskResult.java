package com.miguel_barcelo.async_scheduler.model;

public class TaskResult {

	private final String taskName;
	private final boolean success;
	private final long durationMillis;
	private final String threadName;
	
	public TaskResult(String taskName, boolean success, long durationMillis, String threadName) {
		this.taskName = taskName;
		this.success = success;
		this.durationMillis = durationMillis;
		this.threadName = threadName;
	}
	
	public String getTaskName() { return taskName; }
	public boolean isSuccess() { return success; }
	public long getDurationMillis() { return durationMillis; }
	public String getThreadName() { return threadName; }
}
