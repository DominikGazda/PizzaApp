package pl.pizzeria.components.pizza.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/pizza")
@RestController
public class PizzaResource {

    private PizzaService pizzaService;

    public PizzaResource(PizzaService pizzaService){
        this.pizzaService = pizzaService;
    }

    @GetMapping("")
    public List <PizzaDto> getAllPizza(){
        return pizzaService.findAllPizza();
    }

    @PostMapping("")
    public ResponseEntity<PizzaDto> savePizza (@RequestBody PizzaDto dto){
        PizzaDto savedPizza = pizzaService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPizza.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedPizza);
    }

    @GetMapping("/{id}")
    public PizzaDto getPizzaById(@PathVariable Long id){
        return pizzaService.findPizzaById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaDto> updatePizza(@PathVariable Long id, @RequestBody PizzaDto dto){
        if(!id.equals(dto.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Object id must be same as in path variable");
        PizzaDto savedDto = pizzaService.update(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedDto.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedDto);
    }

    @DeleteMapping("/{id}")
    public PizzaDto deletePizza(@PathVariable Long id){
        return pizzaService.delete(id);
    }

    @GetMapping("/{id}/toppingList")
    public PizzaToppingsDto getPizzaToppingsList(@PathVariable Long id){
        return pizzaService.findPizzaToppings(id);
    }

    @GetMapping("/search/findByNameIgnoreCase")
    public PizzaDto getPizzaByName( @RequestParam(required = true) String name){
        return pizzaService.getPizzaByName(name);
    }

}
