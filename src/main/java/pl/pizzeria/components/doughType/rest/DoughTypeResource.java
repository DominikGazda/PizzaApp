package pl.pizzeria.components.doughType.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/doughTypes")
public class DoughTypeResource {

    private DoughTypeService doughTypeService;

    @Autowired
    public DoughTypeResource(DoughTypeService doughTypeService){
        this.doughTypeService = doughTypeService;
    }

    @GetMapping("")
    public List<DoughTypeDto> getDoughTypes(){
        return doughTypeService.getAllDoughTypes();
    }

    @GetMapping("/{id}")
    public DoughTypeDto getDoughTypeById(@PathVariable Long id){
        return doughTypeService.findDoughTypeById(id);
    }
}
