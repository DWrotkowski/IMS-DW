package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Orders_items;
import com.qa.ims.utils.Utils;

/**
 * Takes in order details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	/**
	 * Reads all orders to the logger
	 */
	@Override
	
	public List<Order> readAll() {
		
		
		
		LOGGER.info("ALL orders : \n");
		List<Order> orders = orderDAO.readAllTwo();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		
		LOGGER.info("Orders with Items : \n");
		List<Order> orders2 = orderDAO.readAll();
		for (Order order2 : orders2) {
			LOGGER.info(order2);
		}
		
		return orders2;
	}

	/**
	 * Creates a order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter a order's customer's id");
		Long customers = utils.getLong();
		Order order = orderDAO.create(new Order(customers));
		LOGGER.info("Order created, now you need add some items");
		return order;
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter a customer");
		Long customers = utils.getLong();
		Order order = orderDAO.update(new Order(order_id, customers));
		LOGGER.info("Order Updated");
		return order;
	}

	/**
	 * Deletes an existing order by the id of the order
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long order_id = utils.getLong();
		return orderDAO.delete(order_id);
	}
	
	
	public Order add_item() {
		LOGGER.info("Please enter the id of the order you would like to add item");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter a item");
		Long items = utils.getLong();
		Orders_items order = orderDAO.add_item(new Orders_items(order_id, items));
		LOGGER.info("Item added to order");
		return order;
	}

	
	public int remove_item() {
		LOGGER.info("Please enter the id of the order from  you would like remove item");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long items = utils.getLong();
		return orderDAO.remove_item(order_id,items);
	}
	
	
	public int calc_value() {
		LOGGER.info("Please enter the id of the order's value you would like calculate ");
		Long order_id = utils.getLong();
		return orderDAO.calc_value(order_id);
	}


}
