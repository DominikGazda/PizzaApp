package pl.pizzeria.components.sizePizza.rest;

import org.springframework.stereotype.Service;
import pl.pizzeria.components.sizePizza.SizePizzaRepository;
import pl.pizzeria.components.sizePizza.exception.SizePizzaNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SizePizzaService {

    private SizePizzaRepository sizePizzaRepository;

    public SizePizzaService(SizePizzaRepository sizePizzaRepository){
        this.sizePizzaRepository = sizePizzaRepository;
    }

    public List<SizePizzaDto> findAllSizePizza(){
        return sizePizzaRepository.findAll()
                .stream()
                .map(SizePizzaMapper::toDto)
                .collect(Collectors.toList());
    }

    public SizePizzaDto findSizePizzaById(Long id){
        return sizePizzaRepository.findById(id)
                .map(SizePizzaMapper::toDto).orElseThrow(SizePizzaNotFoundException::new);
    }
}
