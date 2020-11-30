package pl.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pizzeria.component.OrderStatus;
import pl.pizzeria.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllByStatus(OrderStatus orderStatus);
}
