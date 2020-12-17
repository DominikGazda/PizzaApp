package pl.pizzeria.components.client;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pizzeria.components.client.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {

    Optional<Client> findTopByOrderByIdDesc();
}
