package pl.pizzeria.components.pizza.rest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.server.ResponseStatusException;
import pl.pizzeria.components.pizza.Pizza;
import pl.pizzeria.components.pizza.PizzaRepository;
import pl.pizzeria.components.pizza.exceptions.PizzaNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PizzaService {

    private PizzaRepository pizzaRepository;
    private PizzaMapper pizzaMapper;

    public PizzaService(PizzaRepository pizzaRepository, PizzaMapper pizzaMapper){
        this.pizzaRepository = pizzaRepository;
        this.pizzaMapper = pizzaMapper;
    }

    public List<PizzaDto> findAllPizza(){
        return pizzaRepository.findAll().stream().map(pizzaMapper::toDto).collect(Collectors.toList());
    }

    public PizzaDto save(PizzaDto pizzaDto){
        if(pizzaDto.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Pizza cannot have id");
        return mapAndSavePizza(pizzaDto);

    }

    private PizzaDto mapAndSavePizza(PizzaDto dto){
          Pizza pizza = pizzaMapper.toEntity(dto);
          Pizza savedPizza = pizzaRepository.save(pizza);
          return pizzaMapper.toDto(savedPizza);
    }

    public PizzaDto findPizzaById(Long id){
        return pizzaRepository.findById(id)
                .map(pizzaMapper::toDto)
                .orElseThrow(PizzaNotFoundException::new);
    }

    public PizzaDto update(PizzaDto dto){
        return mapAndSavePizza(dto);
    }

    public PizzaDto delete(Long id){
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        Pizza pizzaToDelete = pizza.orElseThrow(PizzaNotFoundException::new);
        pizzaRepository.delete(pizzaToDelete);
        return pizzaMapper.toDto(pizzaToDelete);
    }

    public PizzaToppingsDto findPizzaToppings(Long id){
        return pizzaRepository.findById(id)
                .map(PizzaToppingsDtoMapper::toDto)
                .orElseThrow(PizzaNotFoundException::new);
    }

    public PizzaDto getPizzaByName(String name){
        return pizzaRepository.findByNameIgnoreCase(name)
                .map(pizzaMapper::toDto)
                .orElseThrow(PizzaNotFoundException::new);
    }

    public void checkErrors(BindingResult result){
        List<ObjectError> errors = result.getAllErrors();
        String message = errors.stream()
                .map(ObjectError::getDefaultMessage)
                .map(String::toString)
                .collect(Collectors.joining());
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,message);
    }

}
