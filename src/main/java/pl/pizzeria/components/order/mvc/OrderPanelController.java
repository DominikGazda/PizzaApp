package pl.pizzeria.components.order.mvc;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.pizzeria.components.order.OrderStatus;
import pl.pizzeria.components.order.Order;
import pl.pizzeria.components.order.OrderRepository;

import java.awt.print.Pageable;
import java.util.List;

@Controller
public class OrderPanelController {

    private OrderRepository orderRepository;

    public OrderPanelController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;

    }

    @GetMapping("/zamowienia/panel")
    public String orderPanel(@RequestParam(required = false) OrderStatus status, Model model){
        List<Order>orders;
        if(status == null){
            orders = orderRepository.findAllWithoutPagination();
        }
        else{
            orders = orderRepository.findAllByStatus(status);
        }
        model.addAttribute("orderList",orders);
        return "orderPanel";
    }

    @GetMapping("/zamowienia/panel/szczegoly/{id}")
    public String orderPanelDetails(@PathVariable Long id,  Model model){
        Order order = orderRepository.findById(id).get();
        if(order.getStatus() == OrderStatus.NEW){
            order.setStatus(OrderStatus.IN_PROGRESS);
        }
        else if(order.getStatus() == OrderStatus.IN_PROGRESS){
            order.setStatus(OrderStatus.COMPLETE);
        }
        orderRepository.save(order);
        return "redirect:/zamowienia/panel";
    }
}
