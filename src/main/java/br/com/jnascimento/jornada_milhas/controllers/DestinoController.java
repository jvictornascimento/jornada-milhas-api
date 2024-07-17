package br.com.jnascimento.jornada_milhas.controllers;

import br.com.jnascimento.jornada_milhas.models.DepoimentoModel;
import br.com.jnascimento.jornada_milhas.models.DestinoModel;
import br.com.jnascimento.jornada_milhas.services.DepoimentoService;
import br.com.jnascimento.jornada_milhas.services.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.PrintStream;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/destinos")
public class DestinoController {
    @Autowired
    private DestinoService service;

    @GetMapping("/{uuid}")
    public ResponseEntity<DestinoModel> getOne(@PathVariable(name = "uuid") UUID uuid){
        return ResponseEntity.status(HttpStatus.OK).body(service.getOne(uuid));
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
    public ResponseEntity<DestinoModel> save(@RequestBody DestinoModel destinoModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveOrUpdate(destinoModel));
    }
    @PutMapping("/{uuid}")
    public ResponseEntity<DestinoModel> update(@PathVariable(name = "uuid") UUID uuid, @RequestBody DestinoModel destinoModel){
        destinoModel.setId(uuid);
        return ResponseEntity.status(HttpStatus.OK).body(service.saveOrUpdate(destinoModel));
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity delete(@PathVariable(name = "uuid") UUID uuid){
        service.delete(uuid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
