package com.example.demo.DTO;


public class BalcaoDTO {

    private Long id;
    private String chamados;
    private Long atendenteId;


    public BalcaoDTO() {}

    public BalcaoDTO(Long id, String chamados,Long atendenteId) {
        this.id = id;
        this.chamados = chamados;
        this.atendenteId = atendenteId;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChamados() {
        return chamados;
    }

    public void setChamados(String chamados) {
        this.chamados = chamados;
    }

    public Long getAtendenteId() {
        return atendenteId;
    }

    public void setAtendenteId(Long atendenteId) {
        this.atendenteId = atendenteId;
    }
}
