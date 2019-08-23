package com.app.tests;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.app.custom.CustomThreadFactory;
import com.app.runnables.LoggingProcessor;

/**
 * @author Anudeep
 *
 */
public class TestCustomThreadFactory {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3, new CustomThreadFactory());
		
		for (int i = 0; i < 6; i++) {
			executorService.submit(new LoggingProcessor());
		}
	}
}
