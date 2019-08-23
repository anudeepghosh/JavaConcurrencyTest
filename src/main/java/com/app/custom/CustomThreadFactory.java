package com.app.custom;

import java.util.concurrent.ThreadFactory;

/**
 * @author Anudeep
 *
 */
public class CustomThreadFactory implements ThreadFactory {

	private static int counter=0;
	
	@Override
	public Thread newThread(Runnable r) {
		
		Thread thread = new Thread(r);
		thread.setName("Custom Thread "+(++counter));
		//thread.setDaemon(true);
		//thread.setPriority(2);
		
		return thread;
	}

}
