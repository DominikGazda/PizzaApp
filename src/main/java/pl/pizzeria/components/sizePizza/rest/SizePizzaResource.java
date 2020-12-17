package pl.pizzeria.components.sizePizza.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pizzeria.components.sizePizza.SizePizza;

import java.util.List;

@RestController
@RequestMapping("/api/sizePizza")
public class SizePizzaResource {

    private SizePizzaService sizePizzaService;

    public SizePizzaResource(SizePizzaService sizePizzaService){
        this.sizePizzaService = sizePizzaService;
    }

    @GetMapping("")
    public List<SizePizzaDto> getAllSizePizza(){
        return sizePizzaService.findAllSizePizza();
    }

    @GetMapping("/{id}")
    public SizePizzaDto getSizePizzaById(@PathVariable Long id){
        return sizePizzaService.findSizePizzaById(id);
    }

}
