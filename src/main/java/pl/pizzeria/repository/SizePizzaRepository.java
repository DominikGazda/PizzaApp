package pl.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pizzeria.model.SizePizza;

import java.util.Optional;

public interface SizePizzaRepository extends JpaRepository<SizePizza,Long> {

    Optional<SizePizza> findBySizeIgnoreCase(String size);
}
