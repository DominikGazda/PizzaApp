package pl.pizzeria.components.menuPizza;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pizzeria.components.menuPizza.MenuPizza;

public interface MenuPizzaRepository extends JpaRepository<MenuPizza,Long> {
}
