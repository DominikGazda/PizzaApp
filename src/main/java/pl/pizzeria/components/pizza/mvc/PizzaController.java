package pl.pizzeria.components.pizza.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pizzeria.components.menuPizza.MenuPizza;
import pl.pizzeria.components.menuPizza.MenuPizzaComponent;
import pl.pizzeria.components.pizza.Pizza;
import pl.pizzeria.components.pizza.PizzaRepository;

import java.util.List;

@Controller
@RequestMapping("/")
public class PizzaController {

    private PizzaRepository pizzaRepository;
    private MenuPizzaComponent menuPizzaComponent;

    @Autowired
    public PizzaController (PizzaRepository pizzaRepository, MenuPizzaComponent menuPizzaComponent){
        this.menuPizzaComponent = menuPizzaComponent;
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping("")
    public String home(Model model){
        List<Pizza> pizzaList = pizzaRepository.findAll();
        model.addAttribute("orderList",menuPizzaComponent.getMenuPizzaList());
        model.addAttribute("pizzaList",pizzaList);
        return "index";
    }

}
