package pl.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pizzeria.model.MenuPizza;

public interface MenuPizzaRepository extends JpaRepository<MenuPizza,Long> {
}
