package br.com.jnascimento.jornada_milhas.services;

import br.com.jnascimento.jornada_milhas.models.DepoimentoModel;
import br.com.jnascimento.jornada_milhas.models.DestinoModel;
import br.com.jnascimento.jornada_milhas.repositories.DepoimentoRepository;
import br.com.jnascimento.jornada_milhas.repositories.DestinoRepository;
import br.com.jnascimento.jornada_milhas.services.exceptions.DepoimentoException;
import br.com.jnascimento.jornada_milhas.services.exceptions.DestinoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DestinoService {

    @Autowired
    private DestinoRepository repository;

    public DestinoModel getOne(UUID id){
         return repository.findById(id).orElseThrow(DestinoException::new);
    }
    public List<DestinoModel> getAll(){
        var list = repository.findAll();
        if(list.isEmpty()){
            throw new DestinoException("Ainda não existe nenhum destino");
        }
        return list;
    }
    public DestinoModel saveOrUpdate(DestinoModel model){
        if (model.getId() == null){
            return repository.save(model);
        }else {
            return  repository.save(updateData(model));
        }
    }

    private DestinoModel updateData(DestinoModel model) {
        var data = repository.findById(model.getId()).orElseThrow(DestinoException::new);
            data.setNome((model.getNome()!=null)?model.getNome():data.getNome());
            data.setFoto((model.getFoto()!=null)?model.getFoto():data.getFoto());
            data.setPreco((model.getPreco()!=null)?model.getPreco():data.getPreco());
            return data;
    }

    public void delete(UUID id){
        var depoimento = repository.findById(id);
        if (depoimento.isEmpty()){
            throw new DestinoException("Id: "+ id +" não encontrado!");
        }
         repository.delete(depoimento.get());
    }
    public DestinoModel findByName(String nome){
        var destino = repository.findByNomeContainingIgnoreCase(nome);
        if (destino.isEmpty()){
            throw new DestinoException("Nenhum destino foi encontrado");
        }
        return destino.get();
    }
}
