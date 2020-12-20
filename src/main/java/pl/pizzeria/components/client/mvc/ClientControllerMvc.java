package pl.pizzeria.components.client.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.pizzeria.components.client.Client;
import pl.pizzeria.components.menuPizza.MenuPizzaComponent;
import pl.pizzeria.components.waiter.Waiter;
import pl.pizzeria.components.waiter.WaiterRepository;
import javax.validation.Valid;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
public class ClientControllerMvc {

    private MenuPizzaComponent menuPizzaComponent;
    private WaiterRepository waiterRepository;

    public ClientControllerMvc(MenuPizzaComponent menuPizzaComponent, WaiterRepository waiterRepository, Validator validator){
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
    public String clientData(@Valid @ModelAttribute Client client, BindingResult result, @RequestParam int stolik, @RequestParam int kelner, RedirectAttributes redirectAttributes, Model model){
        if(result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
            Random random = new Random();
            model.addAttribute("random",random.nextInt(3)+1);
            return "clientDetails";
        }

        redirectAttributes.addFlashAttribute("client",client);
        redirectAttributes.addFlashAttribute("desk",stolik);
        redirectAttributes.addFlashAttribute("waiter",kelner);
        return "redirect:/zamowienie/podsumowanie";
    }
}
