package pl.pizzeria.components.client.rest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.server.ResponseStatusException;
import pl.pizzeria.components.client.Client;
import pl.pizzeria.components.client.ClientRepository;
import pl.pizzeria.components.client.exceptions.ClientNotFoundException;
import pl.pizzeria.components.order.Order;
import pl.pizzeria.components.order.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private ClientOrderMapper clientOrderMapper;

    public ClientService(ClientRepository clientRepository, ClientOrderMapper clientOrderMapper, OrderRepository orderRepository){
        this.clientRepository = clientRepository;
        this.clientOrderMapper = clientOrderMapper;
    }

    public List <ClientDto> findAllClients(){
        return clientRepository.findAll()
                .stream()
                .map(ClientMapper::toDto)
                .collect(Collectors.toList());
    }

    public ClientDto saveClient(ClientDto dto){
        if(dto.getId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User cannot have id");

        return mapAndSaveUser(dto);
    }

    public ClientDto findClientById (Long id){
        Optional<Client> foundClient = clientRepository.findById(id);
        Client client = foundClient.orElseThrow(ClientNotFoundException::new);
        return ClientMapper.toDto(client);
    }

    public ClientDto updateClient(ClientDto clientDto){
        Optional<Client> foundClient = clientRepository.findById(clientDto.getId());
        Client client = foundClient.orElseThrow(ClientNotFoundException::new);
        return mapAndSaveUser(clientDto);
    }

    private ClientDto mapAndSaveUser(ClientDto dto){
        Client client = ClientMapper.toEntity(dto);
        Client savedClient = clientRepository.save(client);
        return ClientMapper.toDto(savedClient);
    }

    public ClientDto deleteClient(Long id){
        Optional<Client> foundClient = clientRepository.findById(id);
        Client client = foundClient.orElseThrow(ClientNotFoundException::new);
        clientRepository.delete(client);
        return ClientMapper.toDto(client);
    }

    public List<ClientOrderDto> getClientOrders(Long id){
        return clientRepository.findById(id)
                .map(Client::getOrders).orElseThrow(ClientNotFoundException::new)
                .stream()
                .map(clientOrderMapper::toDto)
                .collect(Collectors.toList());
    }

    public ClientOrderDto getClientOrderById(Long clientId, int orderId){
        Optional<Client> foundClient = clientRepository.findById(clientId);
        Client client = foundClient.orElseThrow(ClientNotFoundException::new);
        try {
            Order order = client.getOrders().get(orderId - 1);
            return clientOrderMapper.toDto(order);
        }catch(IndexOutOfBoundsException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Cannot find order with provided id");
        }
    }

    public void checkErrors(BindingResult result){
        List<ObjectError> errors = result.getAllErrors();
        String message = errors.stream()
                .map(ObjectError::getDefaultMessage)
                .map(String::toString)
                .collect(Collectors.joining());
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,message);
    }

}
