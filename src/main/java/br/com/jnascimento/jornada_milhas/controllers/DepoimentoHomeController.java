package br.com.jnascimento.jornada_milhas.controllers;

import br.com.jnascimento.jornada_milhas.models.DepoimentoModel;
import br.com.jnascimento.jornada_milhas.services.DepoimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping
public class DepoimentoHomeController {
    @Autowired
    private DepoimentoService service;
    @GetMapping("depoimentos-home")
    public ResponseEntity<List<DepoimentoModel>> depoimentos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.depoimentos());
    }
}
