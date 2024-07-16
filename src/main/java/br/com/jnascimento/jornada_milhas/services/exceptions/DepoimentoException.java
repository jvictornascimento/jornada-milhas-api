package br.com.jnascimento.jornada_milhas.services.exceptions;

import br.com.jnascimento.jornada_milhas.models.DepoimentoModel;

import java.io.Serial;
import java.util.UUID;

public class DepoimentoException extends RuntimeException {
    @Serial
    private static final long serialVersionUID =1L;
    public DepoimentoException() {
        super("Id não encontrado");
    }
    public DepoimentoException(String message) {
        super(message);
    }
}
