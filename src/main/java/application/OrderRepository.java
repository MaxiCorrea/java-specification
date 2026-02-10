package application;

import domain.Order;
import domain.OrderId;

public interface OrderRepository {

	Order findById(OrderId id);

	void save(Order order);

}
