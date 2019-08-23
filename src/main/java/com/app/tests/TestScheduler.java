package com.app.tests;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.app.runnables.CleaningScheduler;

/**
 * @author Anudeep
 *
 */
public class TestScheduler {
	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecService.schedule(new CleaningScheduler(), 5, TimeUnit.SECONDS);
	}
}
