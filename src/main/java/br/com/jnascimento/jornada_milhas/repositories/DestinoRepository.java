package br.com.jnascimento.jornada_milhas.repositories;

import br.com.jnascimento.jornada_milhas.models.DestinoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface DestinoRepository extends JpaRepository<DestinoModel, UUID> {
    Optional<DestinoModel> findByNomeContainingIgnoreCase(String name);
}
