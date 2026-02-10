package application;

import domain.Order;
import domain.OrderId;
import domain.spec.CustomerIsNotBlockedSpec;
import domain.spec.OrderHasPositiveTotalSpec;
import domain.spec.OrderHasValidItemCountSpec;
import domain.spec.Specification;

public class ConfirmOrderUseCase {

	private final OrderRepository repository;
	
	public ConfirmOrderUseCase(
			final OrderRepository repository){
		this.repository = repository;
	}
	
	public void execute(
			final OrderId id) {
		Order order = repository.findById(id);
		
		Specification<Order> spec = 
				new OrderHasPositiveTotalSpec().and
				(new CustomerIsNotBlockedSpec()).and
				(new OrderHasValidItemCountSpec());
	
		order.confirm(spec);
		repository.save(order);
	}
	
}
