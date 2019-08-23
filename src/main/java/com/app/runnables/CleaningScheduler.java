package com.app.runnables;

import java.io.File;

/**
 * @author Anudeep
 *
 */
public class CleaningScheduler implements Runnable {

	
	
	@Override
	public void run() {
		
		File folder = new File("./resources/logs");
		File[] files = folder.listFiles();
		for (File file : files) {
			if((System.currentTimeMillis()-file.lastModified())>30*60*1000) {
				System.out.println("This file will be deleted "+file.getName());
				file.delete();
			}
		}
		
	}

}
