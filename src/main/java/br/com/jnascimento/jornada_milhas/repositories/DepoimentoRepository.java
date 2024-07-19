package br.com.jnascimento.jornada_milhas.repositories;

import br.com.jnascimento.jornada_milhas.models.DepoimentoModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface DepoimentoRepository extends JpaRepository<DepoimentoModel, Long> {
    @Query("SELECT d FROM DepoimentoModel d ORDER BY FUNCTION('RANDOM')") // Use 'RANDOM' para PostgreSQL
    List<DepoimentoModel> findRandomDepoimentos(Pageable pageable);
}
