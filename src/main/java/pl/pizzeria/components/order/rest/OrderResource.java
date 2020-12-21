package pl.pizzeria.components.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.pizzeria.components.order.OrderStatus;

import javax.validation.Valid;
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
    public List<OrderDto> getAllOrders(@RequestParam(defaultValue = "0") Integer pageNo,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       @RequestParam(defaultValue = "id") String sortBy){
        return orderService.findAllOrders(pageNo,pageSize,sortBy);
    }

    @PostMapping("")
    public ResponseEntity<OrderDto> saveOrder(@Valid @RequestBody OrderDto dto, BindingResult result){
        if(result.hasErrors())
            orderService.checkErrors(result);
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
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long id,@Valid @RequestBody OrderDto dto, BindingResult result){
        if(result.hasErrors())
            orderService.checkErrors(result);
        if(!id.equals(dto.getOrderId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Updated order must have same id as in path variable");
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
    public ResponseEntity<OrderClientDto> saveOrderClient(@PathVariable Long id,@Valid @RequestBody OrderClientDto orderClientDto, BindingResult result){
        if(result.hasErrors())
            orderService.checkErrors(result);
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

    @GetMapping("/{id}/waiter")
    public OrderWaiterDto getWaiterInOrder(@PathVariable Long id){
        return orderService.findWaiterInOrder(id);
    }

    @PostMapping("/{id}/waiter")
    public ResponseEntity<OrderWaiterDto> saveWaiterInOrder(@PathVariable Long id,@Valid @RequestBody OrderWaiterDto dto, BindingResult result){
        if(result.hasErrors())
            orderService.checkErrors(result);
        if(!id.equals(dto.getOrderId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Object must have same id as path variable");
        OrderWaiterDto savedWaiterInOrder = orderService.saveWaiterInOrder(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedWaiterInOrder.getOrderId())
                .toUri();
        return ResponseEntity.created(location).body(savedWaiterInOrder);

    }

    @DeleteMapping("/{id}/waiter")
    public OrderWaiterDto deleteWaiterInOrder(@PathVariable Long id, @RequestBody OrderWaiterDto dto){
        if(!id.equals(dto.getOrderId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Object must have same id as path variable");
        return orderService.deleteWaiterInOrder(dto);
    }

    @GetMapping("/search/findAllByStatus")
    public List<OrderDto> getAllOrdersByStatus(@RequestParam (required = false) OrderStatus status){
        return orderService.findOrdersBYStatus(status);
    }

}
