package com.qa.ims.persistence.domain;

public class Order  {


	protected Long order_id;
	protected Long customers;
	
	
	public Order( Long customers ) {
		
		this.setCustomers(customers);
	}

	
	
	public Order(Long order_id,  Long customers ) {
		
		this.setOrder_id(order_id) ;
		this.setCustomers(customers);
	}


	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}


	public Long getCustomers() {
		return customers;
	}

	public void setCustomers(Long customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "order_id= " + order_id + ", customers_ id : " + customers +  "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;		
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		return true;
	}



	
	
	

	
	


}