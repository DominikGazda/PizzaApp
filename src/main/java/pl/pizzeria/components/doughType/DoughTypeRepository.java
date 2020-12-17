package pl.pizzeria.components.doughType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pizzeria.components.doughType.DoughType;

import java.util.Optional;

@Repository
public interface DoughTypeRepository extends JpaRepository<DoughType,Long> {

    Optional<DoughType> findByDoughTypeIgnoreCase(String name);
}
