package pl.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pizzeria.component.MenuPizzaComponent;
import pl.pizzeria.model.*;
import pl.pizzeria.repository.DoughTypeRepository;
import pl.pizzeria.repository.PizzaRepository;
import pl.pizzeria.repository.SizePizzaRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class OrderController {

    private PizzaRepository pizzaRepository;
    private DoughTypeRepository doughTypeRepository;
    private SizePizzaRepository sizePizzaRepository;
    private MenuPizzaComponent menuPizzaComponent;
    private Long id = 0L;

    @Autowired
    public OrderController(PizzaRepository pizzaRepository, DoughTypeRepository doughTypeRepository, SizePizzaRepository sizePizzaRepository, MenuPizzaComponent menuPizzaComponent){
        this.pizzaRepository = pizzaRepository;
        this.doughTypeRepository = doughTypeRepository;
        this.sizePizzaRepository = sizePizzaRepository;
        this.menuPizzaComponent = menuPizzaComponent;
    }

    @GetMapping("/zamow/{name}")
    public String orderDetails(@PathVariable String name, Model model){
        Optional <Pizza> pizza = pizzaRepository.findByNameIgnoreCase(name);
        pizza.ifPresent(p-> model.addAttribute("pizza",p));
        return pizza.map(p -> "pizzaDetails").orElse("redirect:/error");
    }

    @PostMapping("/zamow/{name}/szczegoly")
    public String pizzaDetails(@PathVariable String name, @RequestParam String size, @RequestParam  String dough, Model model){
        MenuPizza menuPizza = new MenuPizza();
        double price = 0;
        Optional<DoughType> doughType = doughTypeRepository.findByDoughTypeIgnoreCase(dough);
        Optional<SizePizza>sizePizza = sizePizzaRepository.findBySizeIgnoreCase(size);
        Optional <Pizza> pizza = pizzaRepository.findByNameIgnoreCase(name);
        if(doughType.isPresent()){
            if(sizePizza.isPresent()){
                if(pizza.isPresent()){
                    price += ((pizza.get().getToppings().stream().mapToDouble(Toppings::getPrice).sum())*(sizePizza.get().getToppingDoublePrice()));
                    price += doughType.get().getPrice();
                    menuPizza.setPizza(pizza.get());
                    menuPizza.setSizePizza(sizePizza.get());
                    menuPizza.setDoughType(doughType.get());
                    menuPizza.setId(id++);
                    menuPizza.setPrice(price);
                }
            }
        }
        menuPizzaComponent.getMenuPizzaList().add(menuPizza);

        return "redirect:/";
    }

    @GetMapping("/usun/{name}/{id}")
    public String deletePizzaFromOrderList(@PathVariable String name, @PathVariable int id, Model model){
        List<MenuPizza> menuPizzaList = menuPizzaComponent.getMenuPizzaList().stream().filter(menu -> menu.getId() == id).collect(Collectors.toList());
        menuPizzaComponent.getMenuPizzaList().remove(menuPizzaList.get(0));
        return "redirect:/";
    }
}
