package com.miguel_barcelo.async_scheduler.util;

import java.util.Random;

public class AppConstants {

	private static Random random = new Random();
	
	public static final String[] TASKS = { 
			"CleanExpiredSessions", "RefreshAccessTokens", "PurgeTempFiles", "SyncExternalCatalog", "GenerateDailyReport" 
	}; 
	
	private AppConstants() {}
	
	public static long getRandomSleep(int min, int max) {
		return min + random.nextInt(max - min);
	}
	
	public static boolean hasProbabilities(double probability) {
		return random.nextDouble() < probability;
	}
}
