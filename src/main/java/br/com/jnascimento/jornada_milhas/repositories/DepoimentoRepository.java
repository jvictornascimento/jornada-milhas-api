package br.com.jnascimento.jornada_milhas.repositories;

import br.com.jnascimento.jornada_milhas.models.DepoimentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DepoimentoRepository extends JpaRepository<DepoimentoModel, UUID> {
}
