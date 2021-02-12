package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.account.Account;
import com.qa.ims.account.User;
import com.qa.ims.account.UserDev;

import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

	@Mock
	private Utils utils;

	@Mock
	private UserDev dev;

	@InjectMocks
	private Account account;

	@Test
	public void testCreate() {
		final String username = "dan";
		final String password = "321";
		final User created = new User(username, password);

		Mockito.when(utils.getString()).thenReturn(username, password);
		Mockito.when(dev.create(created)).thenReturn(created);

		assertEquals(created, account.create());

		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(dev, Mockito.times(1)).create(created);
	}

	@Test
	public void testLogin() {
		List<User> expected = new ArrayList<>();
		expected.add(new User( "dan", "123"));
		
		Mockito.when(dev.readAll()).thenReturn(expected);

		final String username = "dan";
		final String password = "123";

		Mockito.when(utils.getString()).thenReturn(username, password);
		

		assertEquals(null, this.account.login());

		Mockito.verify(utils, Mockito.times(2)).getString();
		
		
		
		
	}





}
