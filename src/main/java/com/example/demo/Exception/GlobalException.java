package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(AtendenteNaoEncontradoException.class)
    public ResponseEntity<Object> AtendenteNaoEncontradoException(AtendenteNaoEncontradoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AtendenteNãoSalvoException.class)
    public ResponseEntity<Object> AtendenteNãoSalvoException(AtendenteNãoSalvoException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AtendendeNaoEditadoException.class)
    public ResponseEntity<Object> AtendendeNaoEditadoException(AtendenteNãoSalvoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AtendenteNaoDeletado.class)
    public ResponseEntity<Object> AtendenteNaoDeletado(AtendenteNãoSalvoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
