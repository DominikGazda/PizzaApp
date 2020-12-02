package pl.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pizzeria.component.MenuPizzaComponent;
import pl.pizzeria.component.OrderStatus;
import pl.pizzeria.model.Client;
import pl.pizzeria.model.MenuPizza;
import pl.pizzeria.model.Order;
import pl.pizzeria.model.Waiter;
import pl.pizzeria.repository.ClientRepository;
import pl.pizzeria.repository.OrderRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@Controller
public class EndSiteController {

    private MenuPizzaComponent menuPizzaComponent;
    private OrderRepository orderRepository;
    private ClientRepository clientRepository;

    @Autowired
    public EndSiteController(MenuPizzaComponent menuPizzaComponent, OrderRepository orderRepository) {
        this.menuPizzaComponent = menuPizzaComponent;
        this.orderRepository = orderRepository;
    }
    @GetMapping("/koniec")
    public String endSite(Model model){
        menuPizzaComponent.clear();
        return "endSite";
    }

    @PostMapping("/koniec/baza")
    public String addToDatabase(@ModelAttribute Client client, @ModelAttribute Waiter waiter, @RequestParam int desk, @RequestParam String data, Model model){
        List <MenuPizza> menuPizzaList = menuPizzaComponent.getMenuPizzaList();
        if(menuPizzaList.isEmpty())
            return "redirect:/error";
        try {
            clientRepository.findTopByOrderByIdDesc().ifPresent(topClient->{
                client.setId(topClient.getId()+1);
            });
        }catch(NullPointerException e){
            System.err.println("Wartość null ");
            client.setId(null);
        }

        System.out.println(menuPizzaList.size());
        for(int i=0; i<menuPizzaList.size(); i++){
            Order order = createNewOrder(client, waiter, desk, data);
            MenuPizza menuPizza = menuPizzaList.get(i);
            menuPizza.setId(null);
            menuPizza.addOrder(order);
            orderRepository.save(order);
        }
        return "redirect:/koniec";
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
