package application;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import domain.Customer;
import domain.Money;
import domain.Order;
import domain.OrderId;

class ConfirmOrderUseCaseTest {

	@Test
	void shouldNotConfirmOrderWhenCustomerIsBlocked() {
		OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
		Order order = new Order(new OrderId("order-1"), new Money(false), new Customer(true), List.of());
		Mockito.when(orderRepository.findById(new OrderId("order-1"))).thenReturn(order);
		ConfirmOrderUseCase  usecase = new ConfirmOrderUseCase(orderRepository);
		assertThrows(DomainException.class, () -> {
			usecase.execute(new OrderId("order-1"));
		});
	}
	
	@Test
	void shoildConfirmSuccessfulyOrder() {
		OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
		Order order = new Order(new OrderId("order-1"), new Money(true), new Customer(false), List.of("A", "B","C"));
		Mockito.when(orderRepository.findById(new OrderId("order-1"))).thenReturn(order);
		ConfirmOrderUseCase  usecase = new ConfirmOrderUseCase(orderRepository);
		assertDoesNotThrow(() -> {
			usecase.execute(new OrderId("order-1"));
		});
	}

}
