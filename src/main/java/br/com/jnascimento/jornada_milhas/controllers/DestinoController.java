package br.com.jnascimento.jornada_milhas.controllers;

import br.com.jnascimento.jornada_milhas.models.DestinoModel;
import br.com.jnascimento.jornada_milhas.models.dtos.DestinoDto;
import br.com.jnascimento.jornada_milhas.services.DestinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/destinos")
public class DestinoController {
    @Autowired
    private DestinoService service;

    @GetMapping("/{id}")
    public ResponseEntity<DestinoDto> getOne(@PathVariable(name = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getOne(id));
    }
    @GetMapping()
    public ResponseEntity<List<DestinoModel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }
    @GetMapping("/buscar")
    public ResponseEntity<DestinoModel>findByNome(@RequestParam String nome){
        System.out.println("aqui");
        return ResponseEntity.status(HttpStatus.OK).body(service.findByName(nome));
    }
    @PostMapping
    public ResponseEntity<DestinoModel> save(@RequestBody @Valid DestinoModel destinoModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveOrUpdate(destinoModel));
    }
    @PutMapping("/{id}")
    public ResponseEntity<DestinoModel> update(@PathVariable(name = "id") Long uuid, @RequestBody  DestinoModel destinoModel){
        destinoModel.setId(uuid);
        return ResponseEntity.status(HttpStatus.OK).body(service.saveOrUpdate(destinoModel));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") Long uuid){
        service.delete(uuid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
