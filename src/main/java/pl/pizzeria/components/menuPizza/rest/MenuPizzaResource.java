package pl.pizzeria.components.menuPizza.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/menuPizza")
public class MenuPizzaResource {

    private MenuPizzaService menuPizzaService;

    public MenuPizzaResource(MenuPizzaService menuPizzaService) {
        this.menuPizzaService = menuPizzaService;
    }

    @GetMapping("")
    public List<MenuPizzaDto> getAllMenuPizza() {
        return menuPizzaService.findAllMenuPizza();
    }

    @PostMapping("")
    public ResponseEntity<MenuPizzaDto> saveMenuPizza(@Valid @RequestBody MenuPizzaDto dto, BindingResult result) {
        if(result.hasErrors())
            menuPizzaService.checkErrors(result);
        MenuPizzaDto savedMenu = menuPizzaService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedMenu.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedMenu);
    }

    @GetMapping("/{id}")
    public MenuPizzaDto getMenuPizzaById(@PathVariable Long id) {
        return menuPizzaService.findMenuPizzaById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuPizzaDto> updateMenuPizza(@PathVariable Long id,@Valid @RequestBody MenuPizzaDto dto, BindingResult result) {
        if(result.hasErrors())
            menuPizzaService.checkErrors(result);
        if (!id.equals(dto.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Menu pizza id must be same as path variable");
        MenuPizzaDto updatedMenu = menuPizzaService.update(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updatedMenu.getId())
                .toUri();
        return ResponseEntity.created(location).body(updatedMenu);
    }

    @DeleteMapping("/{id}")
    public MenuPizzaDto deleteMenuPizza(@PathVariable Long id){
        return menuPizzaService.delete(id);
    }

    @GetMapping("/{id}/doughType")
    public String getMenuPizzaDoughType(@PathVariable Long id){
        return menuPizzaService.findMenuPizzaDoughType(id);
    }

    @GetMapping("/{id}/orders")
    public List<MenuPizzaOrderDto> getMenuPizzaOrders(@PathVariable Long id){
        return menuPizzaService.findMenuPizzaOrders(id);
    }

    @GetMapping("/{id}/pizza")
    public MenuPizzaPizzaDto getPizzaMenuPizza(@PathVariable Long id){
        return menuPizzaService.findPizzaInMenuPizza(id);
    }

    @GetMapping("/{id}/sizePizza")
    public String getMenuPizzaSize (@PathVariable Long id){
        return menuPizzaService.findMenuPizzaSize(id);
    }


}
