package pl.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pizzeria.model.Waiter;

import java.util.Optional;

public interface WaiterRepository extends JpaRepository<Waiter,Long> {

    Optional <Waiter> findById(Long id);
    Waiter findByName(String name);
}
