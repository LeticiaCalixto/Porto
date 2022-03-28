package br.inatel.containers.controller;

import br.inatel.containers.model.Movimentacao;
import br.inatel.containers.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService service;

    @PostMapping("/create") // localhost:8080/movimentacao/create
    public Movimentacao create(@RequestBody Movimentacao obj){ // quando chamar a funcao, vou passar um objeto do tipo movimentacao

        obj = service.create(obj);

        return obj;
    }

    @GetMapping("/readAll")
    public List<Movimentacao> readAll(){

        return service.readAll();

    }

    @GetMapping("/read/{id}")
    public Movimentacao read(@PathVariable("id") Long movimentacaoId){
    Movimentacao movimentacao = service.getMovimentacaoById(movimentacaoId);
        if(movimentacao != null)
            return movimentacao;

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody @PathVariable Movimentacao movimentacao, Long id){
        service.update(id, movimentacao);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") Long id){
        service.delete(id);
    }

}
