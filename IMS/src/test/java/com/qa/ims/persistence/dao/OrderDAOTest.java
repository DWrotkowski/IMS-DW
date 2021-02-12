package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.Orders_items;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Order created = new Order(2L,1L);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Orders_items(1L,1L,1L));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Order(1L,1L), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Orders_items(ID, 1L,1L) , DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Order updated = new Order(1L,1L);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
	

	@Test
	public void testAdd_item() {
		final Orders_items created = new Orders_items(1L,1L);
		assertEquals(created, DAO.add_item(created));
	}
	@Test
	public void testRemove_item() {
		
		assertEquals(1l , 1l, DAO.remove_item(1L,1l));
	}
	@Test
	public void testCalc_value() {
		final long ID = 1L;
		assertEquals(5, DAO.calc_value(ID));
	}
	
	@Test
	public void testReadAllTwo() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L,1L));
		assertEquals(expected, DAO.readAllTwo());
	}
	@Test
	  public void readError() {
		 Long foo = 100l;
		 
		 DAO.read(foo);

	  }
	 
	 @Test
	  public void updateEerror() {
		 Order foo = null;
		 
		 DAO.update(foo);

	  }
	 @Test
	  public void createRerror() {
		 Order foo = null;
		 
		 DAO.create(foo);

	  }
	 
	 @Test
	  public void AddError() {
		 Orders_items foo = null;
		 
		 DAO.add_item(foo);

	  }

	
	
	
	
	
}
