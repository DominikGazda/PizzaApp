package pl.pizzeria.components.menuPizza.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pizzeria.components.doughType.DoughType;
import pl.pizzeria.components.doughType.DoughTypeRepository;
import pl.pizzeria.components.menuPizza.MenuPizza;
import pl.pizzeria.components.common.InvalidDataException;
import pl.pizzeria.components.pizza.Pizza;
import pl.pizzeria.components.pizza.PizzaRepository;
import pl.pizzeria.components.sizePizza.SizePizza;
import pl.pizzeria.components.sizePizza.SizePizzaRepository;

import java.util.Optional;

@Service
public class MenuPizzaMapper {

    private PizzaRepository pizzaRepository;
    private SizePizzaRepository sizePizzaRepository;
    private DoughTypeRepository doughTypeRepository;

    @Autowired
    public MenuPizzaMapper(PizzaRepository pizzaRepository, SizePizzaRepository sizePizzaRepository, DoughTypeRepository doughTypeRepository){
        this.pizzaRepository = pizzaRepository;
        this.sizePizzaRepository = sizePizzaRepository;
        this.doughTypeRepository = doughTypeRepository;
    }

    public  MenuPizzaDto toDto(MenuPizza menuPizza){
        MenuPizzaDto menuPizzaDto = new MenuPizzaDto();
        menuPizzaDto.setId(menuPizza.getId());
        menuPizzaDto.setPizzaName(menuPizza.getPizza().getName());
        menuPizzaDto.setDoughType(menuPizza.getDoughType().getDoughType());
        menuPizzaDto.setPizzaSize(menuPizza.getSizePizza().getSize());
        return menuPizzaDto;
    }

    public MenuPizza toEntity (MenuPizzaDto dto){
        Optional<Pizza> pizza = pizzaRepository.findByNameIgnoreCase(dto.getPizzaName());
        Optional<SizePizza> sizePizza = sizePizzaRepository.findBySizeIgnoreCase(dto.getPizzaSize());
        Optional<DoughType> doughType = doughTypeRepository.findByDoughTypeIgnoreCase(dto.getDoughType());

        MenuPizza entity = new MenuPizza();
        entity.setId(dto.getId());
        entity.setPizza(pizza.orElseThrow(() -> new InvalidDataException("Brak pizzy o nazwie: "+ dto.getPizzaName())));
        entity.setDoughType(doughType.orElseThrow(() -> new InvalidDataException("Brak typu ciasta o nazwie "+ dto.getDoughType())));
        entity.setSizePizza(sizePizza.orElseThrow(() -> new InvalidDataException("Brak rozmiaru pizzy o nazwie"+ dto.getPizzaSize())));
        return entity;
    }
}
