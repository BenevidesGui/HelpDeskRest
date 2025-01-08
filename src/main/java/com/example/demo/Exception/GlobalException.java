package com.example.demo.Exception;

import com.example.demo.Exception.AtendenteException.*;
import com.example.demo.Exception.BalcaoException.BalcaoNaoEncontradoException;
import com.example.demo.Exception.BalcaoException.BalcaoNaoSalvoException;
import com.example.demo.Exception.ChamadoException.ChamadoNaoEditadoException;
import com.example.demo.Exception.ChamadoException.ChamadoNaoEncontradoException;
import com.example.demo.Exception.ChamadoException.ChamadoNaoFechadoException;
import com.example.demo.Exception.ChamadoException.LimiteDeChamadosExcedidoException;
import com.example.demo.Exception.MaquinaException.*;
import com.example.demo.Exception.UsuarioException.UsuarioNaoCriadoException;
import com.example.demo.Exception.UsuarioException.UsuarioNaoDeletadoException;
import com.example.demo.Exception.UsuarioException.UsuarioNaoEditadoException;
import com.example.demo.Exception.UsuarioException.UsuarioNaoEncontradoException;
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
    @ExceptionHandler(LimiteDeChamadosExcedidoException.class)
    public ResponseEntity<Object> LimiteDeChamadosExcedidoException(LimiteDeChamadosExcedidoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @ExceptionHandler(ChamadoNaoFechadoException.class)
    public ResponseEntity<Object> ChamadoNaoFechadoException(ChamadoNaoFechadoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<Object> UsuarioNaoEncontradoException(UsuarioNaoEncontradoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsuarioNaoDeletadoException.class)
    public ResponseEntity<Object> UsuarioNaoDeletadoException(UsuarioNaoDeletadoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);  // 409 Conflict
    }

    @ExceptionHandler(UsuarioNaoEditadoException.class)
    public ResponseEntity<Object> UsuarioNaoEditadoException(UsuarioNaoEditadoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);  // 422 Unprocessable Entity
    }

    @ExceptionHandler(UsuarioNaoCriadoException.class)
    public ResponseEntity<Object> UsuarioNaoCriadoException(UsuarioNaoEditadoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);  // 422 Unprocessable Entity
    }

    @ExceptionHandler(MaquinaNaoEncontradaException.class)
    public ResponseEntity<Object> MaquinaNaoEncontradaException(MaquinaNaoEncontradaException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);  // 404 Not Found
    }

    @ExceptionHandler(MaquinaNaoCriadaException.class)
    public ResponseEntity<Object> MaquinaNaoSalvaException(MaquinaNaoCriadaException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);  // 422 Unprocessable Entity
    }

    @ExceptionHandler(MaquinaNaoEditadaException.class)
    public ResponseEntity<Object> MaquinaNaoEditadaException(MaquinaNaoEditadaException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);  // 422 Unprocessable Entity
    }

    @ExceptionHandler(MaquinaNaoDeletadaException.class)
    public ResponseEntity<Object> MaquinaNaoDeletadaException(MaquinaNaoDeletadaException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);  // 409 Conflict
    }

    @ExceptionHandler(UsuarioNaoFornecidoOuInvalidoException.class)
    public ResponseEntity<Object> UsuarioNaoFornecidoOuInvalidoException(UsuarioNaoFornecidoOuInvalidoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);  // 400 Bad Request
    }

    @ExceptionHandler(ChamadoNaoEditadoException.class)
    public ResponseEntity<Object> ChamadoNaoEditadoException(ChamadoNaoEditadoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
