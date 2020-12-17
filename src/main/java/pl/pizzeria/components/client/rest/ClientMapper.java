package pl.pizzeria.components.client.rest;


import pl.pizzeria.components.client.Client;

public class ClientMapper {


    public static ClientDto toDto(Client client){
        ClientDto dto = new ClientDto();
        dto.setId(client.getId());
        dto.setClientName(client.getClientName());
        dto.setClientSurname(client.getClientSurname());
        return dto;
    }

    public static Client toEntity(ClientDto clientDto){
        Client entity = new Client();
        entity.setId(clientDto.getId());
        entity.setClientName(clientDto.getClientName());
        entity.setClientSurname(clientDto.getClientSurname());
        return entity;
    }
}
