package com.example.demo.Exception.MaquinaException;

public class UsuarioNaoFornecidoOuInvalidoException extends RuntimeException {
    public UsuarioNaoFornecidoOuInvalidoException(String message) {
        super(message);
    }
}
