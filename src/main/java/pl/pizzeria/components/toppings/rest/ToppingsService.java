package pl.pizzeria.components.toppings.rest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.pizzeria.components.pizza.exception.PizzaToppingNotFoundException;
import pl.pizzeria.components.toppings.Toppings;
import pl.pizzeria.components.toppings.ToppingsRepository;
import pl.pizzeria.components.toppings.exceptions.ToppingsNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToppingsService {

    private ToppingsRepository toppingsRepository;
    private ToppingsPizzaMapper toppingsPizzaMapper;

    public ToppingsService(ToppingsRepository toppingsRepository, ToppingsPizzaMapper toppingsPizzaMapper){
        this.toppingsRepository = toppingsRepository;
        this.toppingsPizzaMapper = toppingsPizzaMapper;
    }

    public List<ToppingsDto> findAllToppings(){
        return toppingsRepository.findAll()
                .stream()
                .map(ToppingsMapper::toDto)
                .collect(Collectors.toList());
    }

    public ToppingsDto findToppingsById(Long id){
        return toppingsRepository.findById(id)
                .map(ToppingsMapper::toDto)
                .orElseThrow(PizzaToppingNotFoundException::new);
    }

    public ToppingsDto save(ToppingsDto dto){
        if(dto.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Object id must have same id as path variable");
        return mapAndSaveToppings(dto);
    }

    public ToppingsDto update(ToppingsDto dto){
        return mapAndSaveToppings(dto);
    }

    private ToppingsDto mapAndSaveToppings(ToppingsDto dto){
        Toppings toppings = ToppingsMapper.toEntity(dto);
        Toppings savedToppings = toppingsRepository.save(toppings);
        return ToppingsMapper.toDto(savedToppings);
    }

    public ToppingsDto delete(ToppingsDto dto){
        Optional<Toppings> toppings = toppingsRepository.findById(dto.getId());
        Toppings toppingsToDelete = toppings.orElseThrow(ToppingsNotFoundException::new);
        toppingsRepository.delete(toppingsToDelete);
        return dto;
    }

    public ToppingsPizzaDto findPizzaWithToppings(Long id){
       return  toppingsRepository.findById(id)
                .map(toppingsPizzaMapper::toDto)
                .orElseThrow(ToppingsNotFoundException::new);
    }
}
