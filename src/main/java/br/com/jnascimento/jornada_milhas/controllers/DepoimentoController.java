package br.com.jnascimento.jornada_milhas.controllers;

import br.com.jnascimento.jornada_milhas.models.DepoimentoModel;
import br.com.jnascimento.jornada_milhas.services.DepoimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/depoimentos")
public class DepoimentoController {
    @Autowired
    private DepoimentoService service;

    @GetMapping("/{id}")
    public ResponseEntity<DepoimentoModel> getOne(@PathVariable(name = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getOne(id));
    }
    @GetMapping()
    public ResponseEntity<List<DepoimentoModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }
    @PostMapping
    public ResponseEntity<DepoimentoModel> save(@RequestBody DepoimentoModel depoimentoModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveOrUpdate(depoimentoModel));
    }
    @PutMapping("/{id}")
    public ResponseEntity<DepoimentoModel> update(@PathVariable(name = "id") Long id, @RequestBody DepoimentoModel depoimentoModel){
        depoimentoModel.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(service.saveOrUpdate(depoimentoModel));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
