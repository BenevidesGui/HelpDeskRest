package com.example.demo.Exception;

import com.example.demo.Exception.AtendenteException.*;
import com.example.demo.Exception.BalcaoException.BalcaoNaoEncontradoException;
import com.example.demo.Exception.BalcaoException.BalcaoNaoSalvoException;
import com.example.demo.Exception.ChamadoException.ChamadoNaoEncontradoException;
import com.example.demo.Exception.ChamadoException.LimiteDeChamadosExcedidoException;
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

    @ExceptionHandler(AtendenteNaoSalvoException.class)
    public ResponseEntity<Object> AtendenteNãoSalvoException(AtendenteNaoSalvoException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(AtendendeNaoEditadoException.class)
    public ResponseEntity<Object> AtendendeNaoEditadoException(AtendenteNaoSalvoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(AtendenteNaoDeletado.class)
    public ResponseEntity<Object> AtendenteNaoDeletado(AtendenteNaoSalvoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BalcaoNaoEncontradoException.class)
    public ResponseEntity<Object> BalcaoNaoEncontradoException(BalcaoNaoEncontradoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BalcaoNaoSalvoException.class)
    public ResponseEntity<Object> BalcaoNaoSalvoException(BalcaoNaoSalvoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ChamadoNaoEncontradoException.class)
    public ResponseEntity<Object> ChamadoNaoEncontradoException(ChamadoNaoEncontradoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> LimiteDeChamadosExcedidoException(LimiteDeChamadosExcedidoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
