package br.inatel.containers.controller;

import br.inatel.containers.model.Container;
import br.inatel.containers.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/container")
public class ContainerController {

    @Autowired
    private ContainerService service;

    @PostMapping("/create") // localhost:8080/container/create
    public Container create(@RequestBody Container obj){ // quando chamar a funcao, vou passar um objeto do tipo container

        return service.create(obj);

    }

    @GetMapping("/readAll")
    public List<Container> readAll(){

        return service.readAll();

    }

    @GetMapping("/read/{id}")
    public Container read(@PathVariable("id") Long containerId){

        Container container = service.getContainerById(containerId);
        if(container != null)
            return container;

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody @PathVariable Long id, Container container){
        service.update(id, container);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") Long id){
        service.delete(id);
    }

}
