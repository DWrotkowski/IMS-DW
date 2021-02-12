package com.qa.ims.account;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.Utils;



public class Account {
	
	public  final  Logger LOGGER = LogManager.getLogger();
	
	private   UserDev userDev;
	private   Utils utils;
	
	public Account(UserDev userDev, Utils utils) {
		super();
		this.userDev = userDev;
		this.utils = utils;
	}
	
	
	
	public  User login() {

    int b  = 0;
	for(int i=0; i<3; i++) {
		
		b = b + 1;
		System.out.println("Please enter Username");
		String username = utils.getString();
		
		
		System.out.println("Please enter Password");
		String password = utils.getString();
		

		
		User userLogon = (checkUser(username));
		
		if(userLogon != null) {
			if(userLogon.checkPassword(password)) {
				LOGGER.info("Hello " + username );
				break;
			}
			}
		
			else { LOGGER.info("Incorrect password, please try again");
		}
		LOGGER.info("Incorrect username, please try again");
	}
	if(b == 3) {
	LOGGER.info("Attempts exceeded, returning to main menu.");
	return null;
	}
	return null;
	}
	
	private   User checkUser(String username) {
		
		List<User> users = userDev.readAll();
		for (User user : users) {
			if(user.getUsername().equals(username)) {
				return user;
		}
		}
		
		return null;
		
	}
	
	

	public  User create() {
		
		LOGGER.info("Please enter a user name");
		
		String username = utils.getString();
		
		checkUserCreate(username);

		LOGGER.info("Please enter a password");
		String password = utils.getString();


		User account = userDev.create(new User(username, password));
		LOGGER.info("Account created");
  
         return account;

	}
	
	public   String checkUserCreate(String username) {
		String u = username;
		
		List<User> users = userDev.readAll();
		for (User user : users) {
			if(user.getUsername().equals(username)) {
				LOGGER.info("User name already exist");
				create();
		}
		}
		
		return u;
		
	}
	
}