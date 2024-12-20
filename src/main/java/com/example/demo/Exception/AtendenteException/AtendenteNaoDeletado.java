package com.example.demo.Exception.AtendenteException;

public class AtendenteNaoDeletado extends RuntimeException{
    public AtendenteNaoDeletado(String message) {
        super(message);
    }
}
