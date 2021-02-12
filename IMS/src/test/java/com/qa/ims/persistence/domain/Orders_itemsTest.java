package com.qa.ims.persistence.domain;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class Orders_itemsTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Orders_items.class).verify();
	}

}
