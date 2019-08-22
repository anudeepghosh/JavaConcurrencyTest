package com.app.tests;

import com.app.runnables.AppThread;

public class TestThreads {
	
	public static void main(String[] args) {
		AppThread thread1 = new AppThread();// State:NEW
		AppThread thread2 = new AppThread();
		AppThread thread3 = new AppThread();
		
		/*thread1.setPriority(10);
		thread2.setPriority(1);
		thread3.setPriority(2);*/
		thread1.start();// State:RUNNABLE
		thread2.start();
		thread3.start();
		// JVM executes run. State:RUNNING
		// job completed. State:DEAD
		//in-between thread might be paused or it may sleep. State:BLOCKED/WAITING
	}
}
