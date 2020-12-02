package pl.pizzeria.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pizzeria.component.MenuPizzaComponent;
import pl.pizzeria.model.Pizza;
import pl.pizzeria.repository.DoughTypeRepository;
import pl.pizzeria.repository.PizzaRepository;
import pl.pizzeria.repository.SizePizzaRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrderControllerRest {

    private PizzaRepository pizzaRepository;
    private DoughTypeRepository doughTypeRepository;
    private SizePizzaRepository sizePizzaRepository;
    private MenuPizzaComponent menuPizzaComponent;
    private Long id = 0L;

    public OrderControllerRest(){}

    @Autowired
    public OrderControllerRest(PizzaRepository pizzaRepository, DoughTypeRepository doughTypeRepository, SizePizzaRepository sizePizzaRepository, MenuPizzaComponent menuPizzaComponent){
        this.pizzaRepository = pizzaRepository;
        this.doughTypeRepository = doughTypeRepository;
        this.sizePizzaRepository = sizePizzaRepository;
        this.menuPizzaComponent = menuPizzaComponent;
    }

    @GetMapping(path = "/zamow/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPizza(@PathVariable String name){
        return pizzaRepository.findByNameIgnoreCase(name).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
