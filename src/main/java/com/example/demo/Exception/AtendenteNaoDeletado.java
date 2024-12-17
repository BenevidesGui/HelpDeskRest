package com.example.demo.Exception;

public class AtendenteNaoDeletado extends RuntimeException{
    public AtendenteNaoDeletado(String message) {
        super(message);
    }
}
