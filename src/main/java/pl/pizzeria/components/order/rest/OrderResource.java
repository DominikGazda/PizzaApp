package pl.pizzeria.components.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.pizzeria.components.client.rest.ClientOrderDto;
import pl.pizzeria.components.menuPizza.rest.MenuPizzaDto;
import pl.pizzeria.components.menuPizza.rest.MenuPizzaOrderDto;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderResource {

    private OrderService orderService;

    @Autowired
    public OrderResource(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("")
    public List<OrderDto> getAllOrders(){
        return orderService.findAllOrders();
    }

    @PostMapping("")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDto dto){
        OrderDto savedOrder = orderService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedOrder.getOrderId())
                .toUri();
        return ResponseEntity.created(location).body(savedOrder);

    }

    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable Long id){
        return orderService.findOrderByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long id, @RequestBody OrderDto dto){
        if(!id.equals(dto.getOrderId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Updated object must have same id as in path variable");
        OrderDto updatedOrder = orderService.update(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updatedOrder.getOrderId())
                .toUri();
        return ResponseEntity.created(location).body(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public OrderDto deleteOrder(@PathVariable Long id){
        return orderService.delete(id);
    }

    @GetMapping("/{id}/client")
    public OrderClientDto getOrderClient(@PathVariable Long id){
        return orderService.findClientInOrder(id);
    }

    @PostMapping("/{id}/client")
    public ResponseEntity<OrderClientDto> saveOrderClient(@PathVariable Long id, @RequestBody OrderClientDto orderClientDto){
        if(!id.equals(orderClientDto.getOrderId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Object must have same id as in path variable");
        OrderClientDto savedOrderClient = orderService.saveClientInOrder(orderClientDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedOrderClient.getOrderId())
                .toUri();
        return ResponseEntity.created(location).body(savedOrderClient);
    }

    @DeleteMapping("/{id}/client")
    public OrderClientDto deleteOrderClient(@PathVariable Long id, @RequestBody OrderClientDto dto){
        return orderService.deleteClientInOrder(dto);
    }

}
