package pl.pizzeria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.pizzeria.component.MenuPizzaComponent;
import pl.pizzeria.model.Client;
import pl.pizzeria.model.Waiter;
import pl.pizzeria.repository.WaiterRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Optional;
import java.util.Random;

@Controller
public class ClientController {

    private MenuPizzaComponent menuPizzaComponent;
    private WaiterRepository waiterRepository;

    public ClientController(MenuPizzaComponent menuPizzaComponent, WaiterRepository waiterRepository){
        this.menuPizzaComponent = menuPizzaComponent;
        this.waiterRepository = waiterRepository;
    }

    @GetMapping("/klient")
    public String clientDetails(Model model){
        Random random = new Random();
        model.addAttribute("random",random.nextInt(3)+1);
        model.addAttribute("client", new Client());
        return "clientDetails";
    }

    @PostMapping("/klient/dane")
    public String clientData(@ModelAttribute Client client, @RequestParam int stolik, @RequestParam int kelner, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("client",client);
        redirectAttributes.addFlashAttribute("desk",stolik);
        redirectAttributes.addFlashAttribute("waiter",kelner);
        return "redirect:/klient/podsumowanie";
    }

    @GetMapping("/klient/podsumowanie")
    public String orderSummary(Model model, RedirectAttributes redirectAttributes){
        Integer id = (Integer) model.getAttribute("waiter");
        if(id == null){
            redirectAttributes.addFlashAttribute("errorMessage","Nie znaleziono kelnera");
            return "redirect:/error";
        }
        Optional<Waiter> waiter = waiterRepository.findById(Long.valueOf(id));
        model.addAttribute("menuPizza",menuPizzaComponent.getMenuPizzaList());
        model.addAttribute("data", LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM,FormatStyle.MEDIUM)));
        model.addAttribute("waiter",waiter.get());
        return "orderSummary";
    }
}
