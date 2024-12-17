package com.example.demo.DTO;

public class AtendenteDTO {
    private Long id;
    private String nomeAtendente;
    private String numMatricula;

    public AtendenteDTO() {}
    public AtendenteDTO(Long id, String nomeAtendente, String numMatricula) {
        this.id = id;
        this.nomeAtendente = nomeAtendente;
        this.numMatricula = numMatricula;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAtendente() {
        return nomeAtendente;
    }

    public void setNomeAtendente(String nomeAtendente) {
        this.nomeAtendente = nomeAtendente;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }
}
