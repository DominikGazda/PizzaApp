package pl.pizzeria.components.doughType.rest;

import org.springframework.stereotype.Service;
import pl.pizzeria.components.doughType.DoughTypeRepository;
import pl.pizzeria.components.doughType.exceptions.DoughTypeNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoughTypeService {

    private DoughTypeRepository doughTypeRepository;

    public DoughTypeService(DoughTypeRepository doughTypeRepository){
        this.doughTypeRepository = doughTypeRepository;
    }

    public List<DoughTypeDto> getAllDoughTypes(){
        return doughTypeRepository.findAll().stream()
                .map(DoughTypeMapper::toDto)
                .collect(Collectors.toList());
    }

    public DoughTypeDto findDoughTypeById(Long id){
        return doughTypeRepository.findById(id)
                .map(DoughTypeMapper::toDto).orElseThrow(DoughTypeNotFoundException::new);
    }
}
