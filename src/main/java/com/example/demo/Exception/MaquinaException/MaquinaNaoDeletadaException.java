package com.example.demo.Exception.MaquinaException;

public class MaquinaNaoDeletadaException extends RuntimeException {
    public MaquinaNaoDeletadaException(String message) {
        super(message);
    }
}
