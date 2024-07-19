package br.com.jnascimento.jornada_milhas.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_DESTINO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DestinoModel implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private UUID id;
    @NotBlank
    private String nome;
    @NotBlank
    private String foto1;
    @NotBlank
    private String foto2;
    @NotBlank
    @Column(length = 160)
    private String meta;
    private String textoDescritivo;

}
