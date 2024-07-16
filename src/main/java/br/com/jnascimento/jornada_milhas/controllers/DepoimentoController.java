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

    @GetMapping("/{uuid}")
    public ResponseEntity<DepoimentoModel> getOne(@PathVariable(name = "uuid") UUID uuid){
        return ResponseEntity.status(HttpStatus.OK).body(service.getOne(uuid));
    }
    @GetMapping()
    public ResponseEntity<List<DepoimentoModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }
    @PostMapping
    public ResponseEntity<DepoimentoModel> save(@RequestBody DepoimentoModel depoimentoModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveOrUpdate(depoimentoModel));
    }
    @PutMapping("/{uuid}")
    public ResponseEntity<DepoimentoModel> update(@PathVariable(name = "uuid") UUID uuid, @RequestBody DepoimentoModel depoimentoModel){
        depoimentoModel.setId(uuid);
        return ResponseEntity.status(HttpStatus.OK).body(service.saveOrUpdate(depoimentoModel));
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity delete(@PathVariable(name = "uuid") UUID uuid){
        service.delete(uuid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
