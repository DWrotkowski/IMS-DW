package com.qa.ims.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.IMS;
import com.qa.ims.utils.Utils;

/**
 * Action is a collection of commands which are used to determine the type of
 * function to apply to an entity.
 *
 */
public enum Action {
	

	CREATE("To save a new entity into the database"), READ("To read an entity from the database"),
	UPDATE("To change an entity already in the database"), DELETE("To remove an entity from the database"),
	RETURN("To return to domain selection"),
	
	ADD_ITEM("To add iterm to existing order"),REMOVE_ITEM("Remove item from order"),
    CALC_VALUE("Calc value of order");
    
    
    
	


	public static final Logger LOGGER = LogManager.getLogger();

	private String description;

	Action(String description) {
		this.description = description;
	}

	/**
	 * Describes the action
	 */
	public String getDescription() {
		return this.name() + ": " + this.description;
	}

	/**
	 * Prints out all possible actions
	 */
	public static void printActions() {
		if (IMS.menu == 0) {

		for ( Action action : Action.values()) {
			if (action == ADD_ITEM) {
				break;
			}
				LOGGER.info(action.getDescription());
				
			}
		
		
		} else {
			
			for (Action action : Action.values()) {
				LOGGER.info(action.getDescription());
		}
			
		}
		
		
	}

	/**
	 * Gets an action based on a users input. If user enters a non-specified
	 * enumeration, it will ask for another input.
	 * 
	 * @return Action type
	 */
	public static Action getAction(Utils utils) {
		Action action = null;
		do {
			try {
				action = Action.valueOf(utils.getString().toUpperCase());
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		} while (action == null);
		return action;
	}

}
