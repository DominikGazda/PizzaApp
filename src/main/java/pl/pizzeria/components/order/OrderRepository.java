package pl.pizzeria.components.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

    List<Order> findAllByStatus(OrderStatus orderStatus);

    @Query("SELECT MAX(a.id) FROM Order a")
    Optional<Long> findMaxId();

    @Query("SELECT o FROM Order o")
    List<Order> findAllWithoutPagination();
}
