package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import org.junit.Test;


import com.qa.ims.account.User;
import com.qa.ims.account.UserDev;

import com.qa.ims.utils.DBUtils;

public class DevTest {

	private final UserDev  DEV = new UserDev();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}


	@Test
	public void testCreate() {
		final User created = new User( "DANSS", "2111");
		assertEquals(created, DEV.create(created));
	}

	@Test
	public void testReadAll() {
		List<User> expected = new ArrayList<>();
		expected.add(new User( "dan","123" ));
		assertEquals(expected, DEV.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new User( "dan","123" ), DEV.readLatest());
	}
	

	 
	 
	 @Test
	  public void createRerror() {
		 User foo = null;
		 
		 DEV.create(foo);

	  }
	
}
