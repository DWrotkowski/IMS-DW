package com.qa.ims.persistence.dao;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import org.junit.Test;


import com.qa.ims.account.User;
import com.qa.ims.account.UserDev;

import com.qa.ims.utils.DBUtils;

public class DevFailTest {

	private final UserDev  DEV = new UserDev();

	@Before
	public void setup() {
		DBUtils.connect("fail");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}


	@Test
	public void testCreate() {
		final User created = null;
		assertNull(DEV.create(created));
	}

	@Test
	public void testReadAll() {
		List<User> expected = new ArrayList<>();
		assertEquals(expected, DEV.readAll());
	}

	@Test
	public void testReadLatest() {
		assertNull( DEV.readLatest());
	}
	

	
}
