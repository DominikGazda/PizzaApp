package pl.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pizzeria.model.Pizza;

import java.util.Optional;

public interface PizzaRepository extends JpaRepository<Pizza,Long> {

    Optional<Pizza> findByNameIgnoreCase(String name);
    Optional<Pizza> findById(Long id);
}
