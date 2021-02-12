package com.qa.ims.persistence.domain;

public class Orders_items extends Order  {
	
	private Long items;

	public Orders_items(Long order_id, Long customers, Long items) {
		super(order_id, customers);
		this.setOrder_id(order_id);
		this.setCustomers(customers);
		this.setItems(items);
		
	}
	public Orders_items(Long order_id,  Long items) {
		super(order_id);
		this.setItems(items);
		this.setOrder_id(order_id);
	}
	
	
	

	public Long getItems() {
		return items;
	}

	public void setItems(Long items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "order_id= " + order_id + ", customers_ id : " + customers + ", items= " + items+ "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders_items other = (Orders_items) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
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