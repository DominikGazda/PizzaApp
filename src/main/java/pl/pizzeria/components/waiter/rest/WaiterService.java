package pl.pizzeria.components.waiter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.server.ResponseStatusException;
import pl.pizzeria.components.waiter.Waiter;
import pl.pizzeria.components.waiter.WaiterRepository;
import pl.pizzeria.components.waiter.exceptions.WaiterNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WaiterService {

    private WaiterRepository waiterRepository;
    private WaiterOrderMapper waiterOrderMapper;

    @Autowired
    public WaiterService(WaiterOrderMapper waiterOrderMapper, WaiterRepository waiterRepository){
        this.waiterRepository = waiterRepository;
        this.waiterOrderMapper = waiterOrderMapper;
    }

    public List<WaiterDto> findAllWaiters(){
        return waiterRepository.findAll()
                .stream()
                .map(WaiterMapper::toDto)
                .collect(Collectors.toList());
    }

    public WaiterDto save(WaiterDto dto){
        if(dto.getId()!=null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Waiter cannot have id");
       return mapAndSaveWaiter(dto);
    }

    public WaiterDto findWaiterById(Long id){
        return waiterRepository.findById(id)
                .map(WaiterMapper::toDto)
                .orElseThrow(WaiterNotFoundException::new);
    }

    public WaiterDto update(WaiterDto waiterDto){
        return mapAndSaveWaiter(waiterDto);
    }

    public WaiterDto deleteWaiter(Long id){
        Optional<Waiter> waiter = waiterRepository.findById(id);
        Waiter waiterToDelete = waiter.orElseThrow(WaiterNotFoundException::new);
        waiterRepository.delete(waiterToDelete);
        return WaiterMapper.toDto(waiterToDelete);
    }

    private WaiterDto mapAndSaveWaiter(WaiterDto dto){
        Waiter waiterToSave = WaiterMapper.toEntity(dto);
        Waiter savedWaiter = waiterRepository.save(waiterToSave);
        return WaiterMapper.toDto(savedWaiter);
    }

    public List<WaiterOrderDto> findWaiterOrders(Long id){
        return waiterRepository.findById(id)
                .map(Waiter::getOrders).orElseThrow(WaiterNotFoundException::new)
                .stream()
                .map(waiterOrderMapper::toDto)
                .collect(Collectors.toList());
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
