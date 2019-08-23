package com.app.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.app.runnables.LoggingProcessor;

/**
 * @author Anudeep
 *
 */
public class TestOtherAPIs {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		List<Callable<Boolean>> callables = new ArrayList<>();
		try {
			callables.add(new LoggingProcessor());
			callables.add(new LoggingProcessor());
			callables.add(new LoggingProcessor());
			callables.add(new LoggingProcessor());
			callables.add(new LoggingProcessor());
			callables.add(new LoggingProcessor());
			callables.add(new LoggingProcessor());
			callables.add(new LoggingProcessor());
			callables.add(new LoggingProcessor());
			callables.add(new LoggingProcessor());
			
			List<Future<Boolean>> futures = executorService.invokeAll(callables);
			for (Future<Boolean> future : futures) {
				System.out.println("Operation result for invokeAll() : "+future.get());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(TestOtherAPIs.class.getName()).log(Level.SEVERE, "Error in service.invokeAll() call", e);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(TestOtherAPIs.class.getName()).log(Level.SEVERE, "Error in future.get() call", e);
		}
		
		
		try {
			Boolean futureBool = executorService.invokeAny(callables);
			Thread.sleep(1);
			System.out.println("Operation result for invokeAny() : "+futureBool);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			Logger.getLogger(TestOtherAPIs.class.getName()).log(Level.SEVERE, null, e);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			Logger.getLogger(TestOtherAPIs.class.getName()).log(Level.SEVERE, null, e);
		}
		
		executorService.shutdown();
		
		try {
			System.out.println("Did Service shutdown properly? "+executorService.awaitTermination(30, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			executorService.shutdownNow(); // Post time elapse and interruption
			Logger.getLogger(TestOtherAPIs.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
