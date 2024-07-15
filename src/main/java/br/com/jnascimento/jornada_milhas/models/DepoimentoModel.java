package br.com.jnascimento.jornada_milhas.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table (name = "TB_DEPOIMENTOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class DepoimentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private UUID id;

    private String Foto;
    @Column(columnDefinition = "TEXT")
    private String Depoimento;
    private String nomeAutor;

}
