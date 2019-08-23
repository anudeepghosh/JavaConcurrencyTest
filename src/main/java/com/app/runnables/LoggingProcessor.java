package com.app.runnables;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Anudeep
 *
 */
public class LoggingProcessor implements Callable<Boolean>{
	
	@Override
	public Boolean call() throws Exception {
		System.out.println("Name of thread "+Thread.currentThread().getName());
		Logger.getLogger(LoggingProcessor.class.getName()).log(Level.INFO, "Logging demo!");;
		return true;
	}

}
