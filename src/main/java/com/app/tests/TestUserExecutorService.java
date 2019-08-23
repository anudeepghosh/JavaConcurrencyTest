package com.app.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.app.dao.UserDAO;
import com.app.runnables.UserProcessor;

/**
 * 
 * @author Anudeep
 *
 */
public class TestUserExecutorService {
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		List<String> users = getUsersFromFile("./resources/new_users.txt");
		UserDAO userDAO = new UserDAO();
		for (String user : users) {
			//executorService.submit(new UserProcessor(user, userDAO));
			Future<Integer> future = executorService.submit(new UserProcessor(user, userDAO));
			try {
				System.out.println("Result of the operation is: "+future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Logger.getLogger(TestUserExecutorService.class.getName()).log(Level.SEVERE, null, e);
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				Logger.getLogger(TestUserExecutorService.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		executorService.shutdown();
		System.out.println("Main execution is over");
	}
	
	public static List<String> getUsersFromFile(String fileName) {
		List<String> users = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
			String record = null;
			while ((record=br.readLine())!=null) {
				users.add(record);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(TestUserExecutorService.class.getName()).log(Level.SEVERE, null, e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(TestUserExecutorService.class.getName()).log(Level.SEVERE, null, e);
		}
		return users;
	}
}
