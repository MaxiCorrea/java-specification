package domain.spec;

import domain.Order;

public class OrderHasValidItemCountSpec implements Specification<Order> {

	@Override
	public boolean isSatisfiedBy(
			final Order candidate) {
		return candidate.getItems().size() <= 5;
	} 

}
