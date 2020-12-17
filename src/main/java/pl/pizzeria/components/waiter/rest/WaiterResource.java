package pl.pizzeria.components.waiter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/waiter")
public class WaiterResource {

    private WaiterService waiterService;

    @Autowired
    public WaiterResource(WaiterService waiterService){
        this.waiterService = waiterService;
    }

    @GetMapping("")
    public List<WaiterDto> getAllWaiters(){
        return waiterService.findAllWaiters();
    }

    @PostMapping("")
    public ResponseEntity<WaiterDto> saveWaiter(@RequestBody WaiterDto dto){
        WaiterDto savedWaiter = waiterService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedWaiter.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedWaiter);
    }

    @GetMapping("/{id}")
    public WaiterDto getWaiterById(@PathVariable Long id){
        return waiterService.findWaiterById(id);
    }

    @PutMapping("/{id}")
    public WaiterDto updateWaiter(@PathVariable Long id, @RequestBody WaiterDto dto){
        if(!id.equals(dto.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Waiter id must be same as in path variable");
        return waiterService.update(dto);
    }

    @DeleteMapping("/{id}")
    public WaiterDto deleteWaiter(@PathVariable Long id){
        return waiterService.deleteWaiter(id);
    }

    @GetMapping("/{id}/orders")
    public List<WaiterOrderDto> getWaiterOrders(@PathVariable Long id){
        return waiterService.findWaiterOrders(id);
    }

}
