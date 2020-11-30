package pl.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pizzeria.model.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {

    Optional<Client> findTopByOrderByIdDesc();
}
