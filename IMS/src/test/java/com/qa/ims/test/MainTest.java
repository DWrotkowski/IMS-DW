package com.qa.ims.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.IMS;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Orders_items;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class MainTest {

	@Mock
	private Utils utils;

	

	@Test
	public void testUtiltlis() {
		final Long  c =  100l;
		Mockito.when(utils.getLong()).thenReturn(c);
		
		assertEquals(c, utils.getLong());

		
	}

	@Test
	public void testUtiltlisTwo() {
		String input = null;
		Mockito.when(utils.getString()).thenReturn(input);
				assertEquals(input, utils.getString());

		
	}
	@Test
	public void testUtiltlisThree() {
		final Double  c =   0.0;
		Mockito.when(utils.getDouble()).thenReturn(c);
		assertEquals(c, utils.getDouble());

		
	}





	

}
