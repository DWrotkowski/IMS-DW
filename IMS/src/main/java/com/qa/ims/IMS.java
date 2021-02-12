package com.qa.ims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.account.Account;
import com.qa.ims.account.Crud;
import com.qa.ims.account.LoginMenu;
import com.qa.ims.account.UserDev;
import com.qa.ims.controller.Action;
import com.qa.ims.controller.CrudController;
import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.OrderController;
import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class IMS {

	public static final Logger LOGGER = LogManager.getLogger();

	private final CustomerController customers;
	private final ItemController items;
	private final OrderController orders;
	private final Utils utils;
	private final Account accounts;
    public static int menu = 0;
    
	public IMS() {
		this.utils = new Utils();
		final CustomerDAO custDAO = new CustomerDAO();
		this.customers = new CustomerController(custDAO, utils);
		
		final ItemDAO itemDAO = new ItemDAO();
		this.items = new ItemController(itemDAO, utils);
		
		final OrderDAO orderDAO = new OrderDAO();
		this.orders = new OrderController(orderDAO, utils);
		
		final UserDev userDev = new UserDev();
		this.accounts = new Account(userDev, utils);
		
		
	}

	public void usercheck() {
		
		LOGGER.info("Welcome to the Inventory Management System!");
		DBUtils.connect();
		
		LoginMenu log = null;
		do {
			LOGGER.info("What would you like to do today?");
			LoginMenu.printOptions();

			log = LoginMenu.getOption(utils);

			optioncheck(accounts, log);

		} while (log != LoginMenu.EXIT);
	}
	
	
		public void imsSystem() {
		Domain domain = null;
		do {
			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();

			domain = Domain.getDomain(utils);

			domainAction(domain);

		} while (domain != Domain.LOGOUT);
	}
	
	
		private void optioncheck(Account accounts2,  LoginMenu log) {
			
			
			if ( menu == 0) {
				switch (log) {
				case LOGIN:
					accounts2.login();
					imsSystem();
					break;
				case CREATE:
					accounts2.create();
					break;
				
				case EXIT:
					break;
				default:
					break;
				}
				
			}
		}

	private void domainAction(Domain domain) {
		boolean changeDomain = false;
		do {

			CrudController<?> active = null;
			switch (domain) {
			case CUSTOMER:
				active = this.customers;
				menu = 0;
				break;
			case ITEM:
				active = this.items;
				menu = 0;
				break;
			case ORDER:
				active = this.orders;
				menu = 1;
				break;
			case LOGOUT:
				return;
			default:
				break;
			}

			LOGGER.info(() ->"What would you like to do with " + domain.name().toLowerCase() + ":");

			Action.printActions();
			Action action = Action.getAction(utils);

			if (action == Action.RETURN) {
				changeDomain = true;
			} else {
				doAction(active, action);
			}
		} while (!changeDomain);
	}

	public void doAction(CrudController<?> crudController, Action action) {

		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;		
			case ADD_ITEM:
			((OrderController) crudController).add_item();
			break;
		case REMOVE_ITEM:
			((OrderController) crudController).remove_item();
			break;
		case CALC_VALUE:
			((OrderController) crudController).calc_value();
			break;
		
			case RETURN:
			break;
		default:
			break;
		}

	}

}
