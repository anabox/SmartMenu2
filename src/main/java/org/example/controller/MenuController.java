package org.example.controller;

import org.example.dto.DishCreateRequestDto;
import org.example.dto.DishResponseDto;
import org.example.service.ServiceMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/menu")
public class MenuController {
    private ServiceMenu service;

    @Autowired
    public MenuController(ServiceMenu service) {
        this.service = service;
    }
    @PostMapping()
    public DishResponseDto create(@RequestBody DishCreateRequestDto candidate){
        return service.create(candidate);
    }
    @GetMapping("/{id}")
    public DishResponseDto read(@PathVariable("id") long id){
        return service.read(id);
    }
    @GetMapping()
    public List<DishResponseDto> readAll(){
        return service.readAll();
    }
    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id,@RequestBody DishCreateRequestDto dish ){
     service.update(id,dish);
    }
    @DeleteMapping ("/{id}")
    public void delete(@PathVariable("id") long id){
        service.delete(id);
    }

}
