package br.com.jnascimento.jornada_milhas.services.exceptions;

import java.io.Serial;

public class DestinoException extends RuntimeException {
    @Serial
    private static final long serialVersionUID =1L;
    public DestinoException() {
        super("Destino não encontrado");
    }
    public DestinoException(String message) {
        super(message);
    }
}
