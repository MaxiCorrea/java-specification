package domain.spec;

import domain.Order;

public class CustomerIsNotBlockedSpec implements Specification<Order>{

	@Override
	public boolean isSatisfiedBy(
			final Order candidate) {
		return !candidate.getCustomer().isBlocked();
	}

}
