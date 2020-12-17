package pl.pizzeria.components.toppings;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pizzeria.components.toppings.Toppings;

import java.util.Optional;

public interface ToppingsRepository extends JpaRepository<Toppings,Long> {

    Optional<Toppings> findByName(String name);
}
