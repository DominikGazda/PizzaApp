package pl.pizzeria.components.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.pizzeria.components.common.InvalidDataException;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/clients")
public class ClientResource {

    private ClientService clientService;

    @Autowired
    public ClientResource(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("")
    public List<ClientDto> findAllClients(){
        return clientService.findAllClients();
    }

    @PostMapping("")
    public ResponseEntity<ClientDto> saveClient(@Valid @RequestBody ClientDto dto, BindingResult result){
        if(result.hasErrors())
            clientService.checkErrors(result);
        ClientDto savedClient = clientService.saveClient(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedClient.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedClient);
    }

    @GetMapping("/{id}")
    public ClientDto findClientById(@PathVariable Long id){
        return clientService.findClientById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient(@Valid @RequestBody ClientDto clientDto, BindingResult result, @PathVariable Long id){
        if(result.hasErrors())
            clientService.checkErrors(result);
        if(clientDto.getId() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Updated object must have an id");
        if(!clientDto.getId().equals(id))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Updated object must have same id as path variable");
        ClientDto updatedClient = clientService.updateClient(clientDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updatedClient.getId())
                .toUri();
        return ResponseEntity.created(location).body(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ClientDto deleteClient(@PathVariable Long id){
        return clientService.deleteClient(id);
    }

    @GetMapping("/{id}/orders")
    public List<ClientOrderDto> getClientOrders(@PathVariable Long id){
        return clientService.getClientOrders(id);
    }

    @GetMapping("/{id}/orders/{orderId}")
    public ClientOrderDto getClientOrderById(@PathVariable Long id, @PathVariable int orderId){
        return clientService.getClientOrderById(id,orderId);
    }
}

