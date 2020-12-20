package pl.pizzeria.components.menuPizza.rest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.pizzeria.components.common.InvalidDataException;
import pl.pizzeria.components.doughType.DoughType;
import pl.pizzeria.components.menuPizza.MenuPizza;
import pl.pizzeria.components.menuPizza.MenuPizzaRepository;
import pl.pizzeria.components.menuPizza.exceptions.MenuPizzaNotFoundException;
import pl.pizzeria.components.pizza.Pizza;
import pl.pizzeria.components.sizePizza.SizePizza;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuPizzaService {

    private MenuPizzaRepository menuPizzaRepository;
    private MenuPizzaMapper menuPizzaMapper;

    public MenuPizzaService(MenuPizzaRepository menuPizzaRepository, MenuPizzaMapper menuPizzaMapper){
        this.menuPizzaRepository = menuPizzaRepository;
        this.menuPizzaMapper = menuPizzaMapper;
    }

    public List<MenuPizzaDto> findAllMenuPizza(){
        return menuPizzaRepository.findAll().stream()
                .map(menuPizzaMapper::toDto)
                .collect(Collectors.toList());
    }

    public MenuPizzaDto save(MenuPizzaDto dto){
        if(dto.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Menu pizza cannot have id");
        try{
            MenuPizza menuPizza = menuPizzaMapper.toEntity(dto);
            MenuPizza savedMenu = menuPizzaRepository.save(menuPizza);
            return menuPizzaMapper.toDto(savedMenu);
        }catch(InvalidDataException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    public MenuPizzaDto findMenuPizzaById(Long id){
        return menuPizzaRepository.findById(id)
                .map(menuPizzaMapper::toDto).orElseThrow(MenuPizzaNotFoundException::new);
    }

    public MenuPizzaDto update(MenuPizzaDto menuPizzaDto){
        MenuPizza entity = menuPizzaMapper.toEntity(menuPizzaDto);
        MenuPizza savedEntity = menuPizzaRepository.save(entity);
        return menuPizzaMapper.toDto(savedEntity);
    }

    public MenuPizzaDto delete(Long id){
        Optional<MenuPizza> menuPizza = menuPizzaRepository.findById(id);
        MenuPizza menu = menuPizza.orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot found object with provided id ");
        });
        menuPizzaRepository.delete(menu);
        return menuPizzaMapper.toDto(menu);
    }

    public String findMenuPizzaDoughType(Long id){
        return menuPizzaRepository.findById(id)
                .map(MenuPizza::getDoughType)
                .map(DoughType::getDoughType)
                .map(String::toString)
                .orElseThrow(() ->{ throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot found object with provided id ");});
    }

    public List<MenuPizzaOrderDto> findMenuPizzaOrders(Long id){
        return menuPizzaRepository.findById(id)
                .map(MenuPizza::getOrders)
                .orElseThrow(() ->{ throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot found object with provided id ");})
                .stream()
                .map(MenuPizzaOrderMapper::toDto)
                .collect(Collectors.toList());
    }

    public MenuPizzaPizzaDto findPizzaInMenuPizza(Long id){
        Pizza pizza =  menuPizzaRepository.findById(id)
                     .map(MenuPizza::getPizza)
                     .orElseThrow(() ->{ throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot found object with provided id ");});
        return MenuPizzaPizzaMapper.toDto(pizza);
    }

    public String findMenuPizzaSize(Long id){
        return menuPizzaRepository.findById(id)
                .map(MenuPizza::getSizePizza)
                .map(SizePizza::getSize)
                .map(String::toString)
                .orElseThrow(() ->{ throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot found object with provided id ");});

    }
}
