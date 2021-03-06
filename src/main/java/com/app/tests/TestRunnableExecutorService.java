package com.app.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.app.runnables.AppThread;

public class TestRunnableExecutorService {

	static String pathname = "E:\\Udemy\\J2EE - Concurrency & Multithreading\\ProjectResource\\"
			+ "Ex_Files_Java_EE_Concurrency\\Exercise Files\\Resources\\sample.txt";
	
	public static void main(String[] args) {
		Runnable runnable = () -> {
			try(BufferedReader reader = new BufferedReader(new FileReader(new File(pathname)))) {
				String line = null;
				while ((line=reader.readLine())!=null) {
					System.out.println(Thread.currentThread().getName() + " reading line: " + line);
				}
			} catch (FileNotFoundException e) {
				// TODO: handle exception
				Logger.getLogger(AppThread.class.getName()).log(Level.SEVERE,null,e);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Logger.getLogger(AppThread.class.getName()).log(Level.SEVERE,null,e);
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
