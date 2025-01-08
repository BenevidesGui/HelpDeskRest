package com.example.demo.Exception.MaquinaException;

public class MaquinaNaoEncontradaException extends RuntimeException {
    public MaquinaNaoEncontradaException(String message) {
        super(message);
    }
}
