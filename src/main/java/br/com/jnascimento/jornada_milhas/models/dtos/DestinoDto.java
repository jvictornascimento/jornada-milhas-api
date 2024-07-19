package br.com.jnascimento.jornada_milhas.models.dtos;

import br.com.jnascimento.jornada_milhas.models.DestinoModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DestinoDto {
        private String nome;
        private String foto1;
        private String foto2;
        private String meta;
        private String textoDescritivo;
    public DestinoDto(DestinoModel data) {
        this.nome = data.getNome();
        this.foto1 = data.getFoto1();
        this.foto2 = data.getFoto2();
        this.meta = data.getMeta();
        this.textoDescritivo = data.getTextoDescritivo();

    }
}
