package pl.pizzeria.components.toppings.rest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.server.ResponseStatusException;
import pl.pizzeria.components.pizza.exceptions.PizzaToppingNotFoundException;
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
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Topping cannot have id");
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

    public ToppingsDto delete(Long id){
        Optional<Toppings> toppings = toppingsRepository.findById(id);
        Toppings toppingsToDelete = toppings.orElseThrow(ToppingsNotFoundException::new);
        toppingsRepository.delete(toppingsToDelete);
        return ToppingsMapper.toDto(toppingsToDelete);
    }

    public ToppingsPizzaDto findPizzaWithToppings(Long id){
       return  toppingsRepository.findById(id)
                .map(toppingsPizzaMapper::toDto)
                .orElseThrow(ToppingsNotFoundException::new);
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
