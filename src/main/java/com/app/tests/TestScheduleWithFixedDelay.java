package com.app.tests;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.app.runnables.CleaningScheduler;

/**
 * @author Anudeep
 *
 */
public class TestScheduleWithFixedDelay { 
	//Output for a scheduled executor service is returned as a scheduled future object
	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecService.scheduleWithFixedDelay(new CleaningScheduler(), 5, 30, TimeUnit.SECONDS);
		// Starts deleting files 5 seconds after execution and thereafter every 30 seconds past the 
		// completion of previous execution of thread
	}
}
