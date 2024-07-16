package br.com.jnascimento.jornada_milhas.services;

import br.com.jnascimento.jornada_milhas.models.DepoimentoModel;
import br.com.jnascimento.jornada_milhas.repositories.DepoimentoRepository;
import br.com.jnascimento.jornada_milhas.services.exceptions.DepoimentoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepoimentoService {

    @Autowired
    private DepoimentoRepository repository;

    public DepoimentoModel getOne(UUID id){
         return repository.findById(id).orElseThrow(DepoimentoException::new);
    }
    public List<DepoimentoModel> getAll(){
        var list = repository.findAll();
        if(list.isEmpty()){
            throw new DepoimentoException("Ainda não existe nenhum depoimento");
        }
        return list;
    }
    public DepoimentoModel saveOrUpdate(DepoimentoModel model){
        if (model.getId() == null){
            return repository.save(model);
        }else {
            return  repository.save(updateData(model));
        }
    }

    private DepoimentoModel updateData(DepoimentoModel model) {
        var data = repository.findById(model.getId()).orElseThrow(DepoimentoException::new);
            data.setDepoimento((model.getDepoimento()!=null)?model.getDepoimento():data.getDepoimento());
            data.setFoto((model.getFoto()!=null)?model.getFoto():data.getFoto());
            data.setNomeAutor((model.getNomeAutor()!=null)?model.getNomeAutor():data.getNomeAutor());
            return data;
    }

    public void delete(UUID id){
        var depoimento = repository.findById(id);
        if (depoimento.isEmpty()){
            throw new DepoimentoException("Id: "+" não encontrado!");
        }
         repository.delete(depoimento.get());
    }




}
