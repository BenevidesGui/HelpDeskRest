package com.example.demo.Exception.MaquinaException;

public class MaquinaNaoEditadaException extends RuntimeException {
    public MaquinaNaoEditadaException(String message) {
        super(message);
    }
}
