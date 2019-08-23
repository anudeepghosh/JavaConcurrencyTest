package com.app.runnables;

import java.util.StringTokenizer;
import java.util.concurrent.Callable;
import com.app.beans.User;
import com.app.dao.UserDAO;

/**
 * @author Anudeep
 *
 */
public class UserProcessor implements Callable<Integer> { //return type to capture number of updates to DB

	private String userRecord;	// each record from file
	private UserDAO userDAO; 	// access DAO for record insertion
	
	public UserProcessor(String userRecord, UserDAO userDAO) {
		this.userRecord = userRecord;
		this.userDAO = userDAO;
	}
	
	
	@Override
	public Integer call() throws Exception {
		int rows = 0;
		System.out.println(Thread.currentThread().getName()+" processing record for : "+userRecord);
		
		StringTokenizer tokenizer = new StringTokenizer(userRecord, ",");
		User user = null;
		while (tokenizer.hasMoreTokens()) {
			user = new User();
			user.setEmailID(tokenizer.nextToken());
			user.setName(tokenizer.nextToken());
			user.setId(Integer.valueOf(tokenizer.nextToken()));
			rows = userDAO.saveUser(user);
		}
		return rows;
	} 

}
