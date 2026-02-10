package domain;

import java.util.List;

import application.DomainException;
import domain.spec.Specification;

public class Order {

	private OrderId id;
	private Money total;
	private Customer customer;
	private List<String> items;
	
	public Order(
			final OrderId id,
			final Money total,
			final Customer customer,
			final List<String> items) {
		this.id = id;
		this.total = total;
		this.customer = customer;
		this.items = items;
	}
	
	public OrderId getId() {
		return id;
	}
	
	public Money getTotal() {
		return total;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public List<String> getItems() {
		return items;
	}

	public void confirm(
			final Specification<Order> spec) {
		if(!spec.isSatisfiedBy(this)) {
			String msg = "Order cannot be confirmed";
			throw new DomainException(msg);
		}
	}

}
