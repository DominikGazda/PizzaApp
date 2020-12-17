package pl.pizzeria.components.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllByStatus(OrderStatus orderStatus);

    @Query("SELECT MAX(a.id) FROM Order a")
    Optional<Long> findMaxId();
}
