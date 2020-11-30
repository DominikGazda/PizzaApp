package pl.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pizzeria.model.Toppings;

public interface ToppingsRepository extends JpaRepository<Toppings,Long> {
}
