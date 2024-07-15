package br.com.jnascimento.jornada_milhas.services;

import br.com.jnascimento.jornada_milhas.models.DepoimentoModel;
import br.com.jnascimento.jornada_milhas.repositories.DepoimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepoimentoService {

    @Autowired
    private DepoimentoRepository repository;

    public DepoimentoModel getOne(UUID id){
        return null;
    }
    public List<DepoimentoModel> getAll(UUID id){
        return null;
    }
    public DepoimentoModel saveOrUpdate(DepoimentoModel model){
        return null;
    }
    public DepoimentoModel delete(UUID id){
        return null;
    }




}
