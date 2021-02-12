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

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Orders_items;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final Long  customers =  2L;
		final Order created = new Order(customers);

		Mockito.when(utils.getLong()).thenReturn(customers);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Order> customers = new ArrayList<>();
		customers.add(new Orders_items(1l,1L,1L));
		

		Mockito.when(dao.readAll()).thenReturn(customers);

		assertEquals(customers, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Order updated = new Order(1L, 2L);

		Mockito.when(this.utils.getLong()).thenReturn(1L, updated.getCustomers());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(2)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
	
	@Test
	public void testAdd_item() {
		final Long  order_id =  1L;
		final Long  items =  1L;
		final Orders_items created = new Orders_items(order_id,items);

		Mockito.when(utils.getLong()).thenReturn(order_id,items );
		Mockito.when(dao.add_item(created)).thenReturn(created);

		assertEquals(created, controller.add_item());

		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(dao, Mockito.times(1)).add_item(created);
	}
	@Test
	public void testRemove_item() {
		final long ID = 1L;
		final long item = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID,item);
		Mockito.when(dao.remove_item(ID,item)).thenReturn(1);

		assertEquals(1L, this.controller.remove_item());

		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(dao, Mockito.times(1)).remove_item(ID,item);
	}
	@Test
	public void testCalc_value() {
		final long ID = 1;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.calc_value(ID)).thenReturn(5);

		assertEquals(5, this.controller.calc_value());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).calc_value(ID);
	}
	

}
