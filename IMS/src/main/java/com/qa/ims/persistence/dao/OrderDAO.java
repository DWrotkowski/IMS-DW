package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Orders_items;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long order_id = resultSet.getLong("order_id");
		Long customers  = resultSet.getLong("customers");
		return new Order(order_id, customers);
	}
	
	
	
	public int ResultSet(ResultSet resultSet) throws SQLException {
		int sum = resultSet.getInt("SUM(i.value)");
		LOGGER.info("total value of this order is : " + sum);
		return sum;
	}
	
	
	public Orders_items modelFromResultSetTwo(ResultSet resultSet) throws SQLException {
		Long order_id = resultSet.getLong("order_id");
		Long customers  = resultSet.getLong("customers");
		Long items = resultSet.getLong("items");
		return new Orders_items(order_id, customers, items);
	}
	
	public Orders_items modelFromResultSetFour(ResultSet resultSet) throws SQLException {
		Long order_id = resultSet.getLong("order_id");
		Long items = resultSet.getLong("items");
		return new Orders_items(order_id, items);
	}


	/**
	 * Reads all orders from the database
	 * 
	 * @return A list of orders
	 */
	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT o.order_id, o.customers, i.items FROM orders o INNER JOIN orders_items i ON o.order_id=i.order_id;");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSetTwo(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	

	public List<Order> readAllTwo() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	
	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a order in the database
	 * 
	 * @param order - takes in a order object. order_id will be ignored
	 */
	
	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(customers) VALUES (?)");) {
			statement.setLong(1, order.getCustomers());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders_items read(Long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT o.order_id, o.customers, i.items FROM orders o INNER JOIN orders_items i ON o.order_id=i.order_id;");) {
			resultSet.next();
				return modelFromResultSetTwo(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Order readTwo(Long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE order_id = ? ");) {
			statement.setLong(1, order_id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}


	/**
	 * Updates a order in the database
	 * 
	 * @param order - takes in a order object, the order_id field will be used to
	 *                 update that order in the database
	 * @return
	 */
	@Override
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders SET customers = ? WHERE order_id = ?");) {
			statement.setLong(1, order.getCustomers());
			statement.setLong(2, order.getOrder_id());
			statement.executeUpdate();
			return readTwo(order.getOrder_id());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a order in the database
	 * 
	 * @param order_id - order_id of the order
	 */
	@Override
	public int delete(long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?");) {
			statement.setLong(1, order_id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	/**
	 * Updates a order in the database
	 * 
	 * @param order - takes in a order object, the order_id field will be used to
	 *                 update that order in the database
	 * @return
	 */
	
	public Orders_items add_item(Orders_items order)  {
			try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection
							.prepareStatement("INSERT INTO orders_items(order_id, items) VALUES (?, ? )");) {
				statement.setLong(1, order.getOrder_id());
				statement.setLong(2, order.getItems());
				statement.executeUpdate();
				return readLatestTwo();
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return null;
		}
	
	public Orders_items readLatestTwo() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders_items ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSetFour(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	public int remove_item(Long order_id, Long items) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders_items WHERE order_id = ? AND items = ? LIMIT 1");) {
			statement.setLong(1, order_id);
			statement.setLong(2, items);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	
	public int calc_value(Long order_id) {
		
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT SUM(i.value) FROM orders_items o INNER JOIN items i ON o.items=i.item_id WHERE order_id = ?");) {
			    statement.setLong(1, order_id);
			    
			    try (ResultSet resultSet = statement.executeQuery();) {
					resultSet.next();
					return ResultSet(resultSet);
				}

		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
		
	}






	


}
