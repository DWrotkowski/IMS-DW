package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Orders_items;
import com.qa.ims.utils.DBUtils;
import static org.junit.Assert.assertNull;
public class OrderFailTest {

	private final OrderDAO DAO = new OrderDAO();

	@Before
	public void setup() {
		DBUtils.connect("fail");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Order created = new Order(2L,1L);
		assertNull(DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertNull( DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertNull( DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Order updated = new Order(1L,1L);
		assertNull( DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(1));
	}
	

	@Test
	public void testAdd_item() {
		final Orders_items created = new Orders_items(1L,1L);
		assertNull( DAO.add_item(created));
	}
	@Test
	public void testRemove_item() {
		
		assertEquals(0, 0, DAO.remove_item(1L,1L));
	}
	@Test
	public void testCalc_value() {
		final long ID = 1L;
		assertEquals(0, DAO.calc_value(ID));
	}
	
	@Test
	public void testReadAllTwo() {
		List<Order> expected = new ArrayList<>();
		assertEquals(expected, DAO.readAllTwo());
	}


	
	
	
	
	
}
