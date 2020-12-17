package pl.pizzeria.components.sizePizza;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pizzeria.components.sizePizza.SizePizza;

import java.util.Optional;

public interface SizePizzaRepository extends JpaRepository<SizePizza,Long> {

    Optional<SizePizza> findBySizeIgnoreCase(String size);
}
