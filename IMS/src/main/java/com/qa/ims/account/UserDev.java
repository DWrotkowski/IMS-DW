package com.qa.ims.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.utils.DBUtils;


public class UserDev {

	public static final Logger LOGGER = LogManager.getLogger();

	
	public User modelFromResultSet(ResultSet resultSet) throws SQLException {
		String username = resultSet.getString("username");
		String password = resultSet.getString("password");
		return new User(username, password);
	}



	
	public User readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts ORDER BY account_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	

public User create(User account) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO accounts(username, password) VALUES (?, ?)");) {
			statement.setString(1, account.getUsername());
			statement.setString(2, account.getPassword());
			statement.executeUpdate();
			return readLatest();
			
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

public List<User> readAll() {
	try (Connection connection = DBUtils.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts");) {
		List<User> users = new ArrayList<>();
		while (resultSet.next()) {
			users.add(modelFromResultSet(resultSet));
		}
		return users;
	} catch (SQLException e) {
		LOGGER.debug(e);
		LOGGER.error(e.getMessage());
	}
	return new ArrayList<>();
}




}
