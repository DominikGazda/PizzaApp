package pl.pizzeria.components.waiter;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pizzeria.components.waiter.Waiter;

import java.util.Optional;

public interface WaiterRepository extends JpaRepository<Waiter,Long> {

    Optional <Waiter> findById(Long id);
    Waiter findByName(String name);
}
