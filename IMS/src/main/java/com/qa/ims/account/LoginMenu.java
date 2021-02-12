package com.qa.ims.account;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.Utils;

public enum LoginMenu {

	LOGIN("Enter user detalis to access aplication"), CREATE("Create new account"), 
	EXIT("To exit application");

	public static final Logger LOGGER = LogManager.getLogger();

	private String description;

	private LoginMenu(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.name() + ": " + this.description;
	}

	public static void printOptions() {
		for (LoginMenu domain : LoginMenu.values()) {
			LOGGER.info(domain.getDescription());
		}
	}

	public static LoginMenu getOption(Utils utils) {
		LoginMenu domain;
		while (true) {
			try {
				domain = LoginMenu.valueOf(utils.getString().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return domain;
	}

}
