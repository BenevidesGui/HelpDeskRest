package com.example.demo.Exception.ChamadoException;

public class LimiteDeChamadosExcedidoException extends RuntimeException{
    public LimiteDeChamadosExcedidoException (String message) {
        super(message);
    }
}
