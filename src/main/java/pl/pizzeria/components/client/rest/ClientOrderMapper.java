package pl.pizzeria.components.client.rest;

import org.springframework.stereotype.Service;
import pl.pizzeria.components.common.InvalidDataException;
import pl.pizzeria.components.order.Order;
import pl.pizzeria.components.order.OrderStatus;
import pl.pizzeria.components.waiter.Waiter;
import pl.pizzeria.components.waiter.WaiterRepository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ClientOrderMapper {

    private WaiterRepository waiterRepository;

    public ClientOrderMapper(WaiterRepository waiterRepository){
        this.waiterRepository = waiterRepository;
    }

    public  ClientOrderDto toDto (Order order){
        ClientOrderDto dto = new ClientOrderDto();
        dto.setOrderId(order.getId());
        dto.setDeskNumber(order.getTableNumber());
        dto.setStatus(order.getStatus());
        dto.setWaiterId(order.getWaiter().getId());
        return dto;
    }

    public  Order toEntity(ClientOrderDto dto){
        Optional<Waiter> waiter = waiterRepository.findById(dto.getWaiterId());

        Order order = new Order();
        order.setId(dto.getOrderId());
        order.setWaiter(waiter.orElseThrow(() -> {
            throw new InvalidDataException("Nie znaleziono kelnera");
        }));
        order.setDate(Date.valueOf(LocalDateTime.now().toLocalDate()));
        order.setTableNumber(dto.getDeskNumber());
        order.setStatus(OrderStatus.NEW);
        return order;
    }
}
