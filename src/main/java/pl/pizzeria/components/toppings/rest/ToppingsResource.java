package pl.pizzeria.components.toppings.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/toppings")
public class ToppingsResource {

    private ToppingsService toppingsService;

    @Autowired
    public ToppingsResource(ToppingsService toppingsService){
        this.toppingsService = toppingsService;
    }

    @GetMapping("")
    public List<ToppingsDto> getAllToppings(){
        return toppingsService.findAllToppings();
    }

    @PostMapping("")
    public ResponseEntity<ToppingsDto> saveToppings(@RequestBody ToppingsDto toppingsDto){
        ToppingsDto savedToppings = toppingsService.save(toppingsDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedToppings.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedToppings);
    }

    @GetMapping("/{id}")
    public ToppingsDto getToppingsById(@PathVariable Long id){
        return toppingsService.findToppingsById(id);
    }

    @PutMapping("/{id}")
    public ToppingsDto updateToppings(@PathVariable Long id, @RequestBody ToppingsDto dto){
        if(!id.equals(dto.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Updated object id must be same as path variable");
        return toppingsService.update(dto);
    }

    @DeleteMapping("/{id}")
    public ToppingsDto deleteToppings(@PathVariable ToppingsDto dto){
        return toppingsService.delete(dto);
    }

    @GetMapping("/{id}/pizza")
    public ToppingsPizzaDto getPizzaWithToppings(@PathVariable Long id){
        return toppingsService.findPizzaWithToppings(id);
    }
}
