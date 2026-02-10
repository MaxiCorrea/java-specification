package domain.spec;

import domain.Order;

public class OrderHasPositiveTotalSpec implements Specification<Order>{

	@Override
	public boolean isSatisfiedBy(
			final Order candidate) {
		return candidate.getTotal().isPositive();
	}

}
