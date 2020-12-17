package pl.pizzeria.components.order.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.pizzeria.components.client.Client;
import pl.pizzeria.components.client.ClientRepository;
import pl.pizzeria.components.menuPizza.MenuPizzaComponent;
import pl.pizzeria.components.doughType.DoughType;
import pl.pizzeria.components.menuPizza.MenuPizza;
import pl.pizzeria.components.order.Order;
import pl.pizzeria.components.order.OrderRepository;
import pl.pizzeria.components.order.OrderStatus;
import pl.pizzeria.components.pizza.Pizza;
import pl.pizzeria.components.sizePizza.SizePizza;
import pl.pizzeria.components.toppings.Toppings;
import pl.pizzeria.components.doughType.DoughTypeRepository;
import pl.pizzeria.components.pizza.PizzaRepository;
import pl.pizzeria.components.sizePizza.SizePizzaRepository;
import pl.pizzeria.components.waiter.Waiter;
import pl.pizzeria.components.waiter.WaiterRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class OrderControllerMvc {

    private PizzaRepository pizzaRepository;
    private DoughTypeRepository doughTypeRepository;
    private SizePizzaRepository sizePizzaRepository;
    private MenuPizzaComponent menuPizzaComponent;
    private WaiterRepository waiterRepository;
    private OrderRepository orderRepository;
    private ClientRepository clientRepository;
    private Long id = 0L;

    @Autowired
    public OrderControllerMvc(PizzaRepository pizzaRepository, DoughTypeRepository doughTypeRepository, SizePizzaRepository sizePizzaRepository, MenuPizzaComponent menuPizzaComponent, WaiterRepository waiterRepository, OrderRepository orderRepository){
        this.pizzaRepository = pizzaRepository;
        this.doughTypeRepository = doughTypeRepository;
        this.sizePizzaRepository = sizePizzaRepository;
        this.menuPizzaComponent = menuPizzaComponent;
        this.waiterRepository = waiterRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/zamowienie/{name}")
    public String orderDetails(@PathVariable String name, Model model){
        Optional <Pizza> pizza = pizzaRepository.findByNameIgnoreCase(name);
        pizza.ifPresent(p-> model.addAttribute("pizza",p));
        return pizza.map(p -> "pizzaDetails").orElse("redirect:/error");
    }

    @PostMapping("/zamowienie/{name}/szczegoly")
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

    @GetMapping("/zamowienie/usun/{name}/{id}")
    public String deletePizzaFromOrderList(@PathVariable String name, @PathVariable int id, Model model){
        List<MenuPizza> menuPizzaList = menuPizzaComponent.getMenuPizzaList().stream().filter(menu -> menu.getId() == id).collect(Collectors.toList());
        menuPizzaComponent.getMenuPizzaList().remove(menuPizzaList.get(0));
        return "redirect:/";
    }

    @GetMapping("/zamowienie/podsumowanie")
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

    @GetMapping("/zamowienie/koniec")
    public String endSite(Model model){
        menuPizzaComponent.clear();
        return "endSite";
    }

    @PostMapping("/zamowienie/koniec/baza")
    public String addToDatabase(@ModelAttribute Client client, @ModelAttribute Waiter waiter, @RequestParam int desk, @RequestParam String data, Model model){
        List <MenuPizza> menuPizzaList = menuPizzaComponent.getMenuPizzaList();
        if(menuPizzaList.isEmpty())
            return "redirect:/error";
        try {
            clientRepository.findTopByOrderByIdDesc().ifPresent(topClient->{
                client.setId(topClient.getId()+1);
            });
        }catch(NullPointerException e){
            client.setId(null);
        }

        for(int i=0; i<menuPizzaList.size(); i++){
            Order order = createNewOrder(client, waiter, desk, data);
            MenuPizza menuPizza = menuPizzaList.get(i);
            menuPizza.setId(null);
            menuPizza.addOrder(order);
            orderRepository.save(order);
        }
        return "redirect:/zamowienie/koniec";
    }

    private Order createNewOrder(Client client, Waiter waiter, int desk, String data) {
        Order order = new Order();
        try{
            java.util.Date date = new SimpleDateFormat("dd MMM yyyy").parse(data);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            order.setDate(sqlDate);
        }catch(ParseException parseException){
            parseException.getMessage();
        }
        order.setStatus(OrderStatus.NEW);
        order.setClient(client);
        order.setWaiter(waiter);
        order.setTableNumber(desk);

        return order;
    }
}
