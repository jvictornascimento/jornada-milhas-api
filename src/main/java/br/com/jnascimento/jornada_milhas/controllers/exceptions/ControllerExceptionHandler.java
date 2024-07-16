package br.com.jnascimento.jornada_milhas.controllers.exceptions;


import br.com.jnascimento.jornada_milhas.services.exceptions.DepoimentoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(DepoimentoException.class)
    public ResponseEntity<StandardError> DepoimentoNotFond(DepoimentoException e , HttpServletRequest request){
        String error = "Depoimento Error!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
