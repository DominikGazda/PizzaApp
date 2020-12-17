package pl.pizzeria.components.pizza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.pizzeria.components.pizza.Pizza;
import pl.pizzeria.components.toppings.Toppings;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends JpaRepository<Pizza,Long> {

    Optional<Pizza> findByNameIgnoreCase(String name);
    Optional<Pizza> findById(Long id);

    @Query("SELECT t.id, t.name, t.price FROM Toppings t JOIN t.pizza pt "+
    "WHERE pt.id = :pizzaId")
    List<Toppings> findAllPizzaToppings(@Param("pizzaId") Long index);
}
