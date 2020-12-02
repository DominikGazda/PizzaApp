package pl.pizzeria.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.pizzeria.component.MenuPizzaComponent;
import pl.pizzeria.model.Pizza;
import pl.pizzeria.repository.PizzaRepository;
import java.util.List;

@Controller
public class HomeController {

    private PizzaRepository pizzaRepository;
    private MenuPizzaComponent menuPizzaComponent;

    @Autowired
    public HomeController (PizzaRepository pizzaRepository, MenuPizzaComponent menuPizzaComponent){
        this.pizzaRepository = pizzaRepository;
        this.menuPizzaComponent = menuPizzaComponent;
    }

    @GetMapping("/")
    public String home(Model model){
        List<Pizza> pizzaList = pizzaRepository.findAll();
        model.addAttribute("orderList",menuPizzaComponent.getMenuPizzaList());
        model.addAttribute("pizzaList",pizzaList);
        return "index";
    }


}
