package com.qa.ims.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.IMS;
import com.qa.ims.Runner;
import com.qa.ims.account.User;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.utils.Utils;

import nl.jqno.equalsverifier.EqualsVerifier;

@RunWith(MockitoJUnitRunner.class)
public class ExtraTest {
	@SuppressWarnings("unused")
	private final IMS IMS = new IMS();
	@SuppressWarnings("unused")
	private final Runner Runner = new Runner();

	@Mock
	private Utils utils;
	

	

	@Test
	public void testUtiltlis() {
		final Long  c =  null;
		Mockito.when(utils.getLong()).thenReturn(c);
		
		assertNull( utils.getLong());
		

		
	}

	@Test
	public void testUtiltlisTwo() {
		String input = null;
		Mockito.when(utils.getString()).thenReturn(input);
		assertNull( utils.getString());

		
	}
	@Test
	public void testUtiltlisThree() {
		final Double  c =   0.0;
		Mockito.when(utils.getDouble()).thenReturn(c);
		assertEquals(c, utils.getDouble());

		
	}
	
	@Test
	public void test() {
		final Long  c =  2L;
		Mockito.when(utils.getLong()).thenReturn(c);
		
		assertEquals(c, utils.getLong());

		
	}



}
