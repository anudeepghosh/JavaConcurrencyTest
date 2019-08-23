/**
 * 
 */
package com.app.tests;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.app.runnables.CleaningScheduler;

/**
 * @author Anudeep
 *
 */
public class TestScheduleAtFixedRate {
	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecService.scheduleAtFixedRate(new CleaningScheduler(), 5, 30, TimeUnit.SECONDS);
		// Starts deleting files 5 seconds after execution and after every 30 seconds hence 
	}
}
