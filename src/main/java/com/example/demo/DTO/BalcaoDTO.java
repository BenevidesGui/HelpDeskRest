package com.example.demo.DTO;


import java.util.List;

public class BalcaoDTO {

    private Long id;
    private List chamados;
    private Long atendenteId;


    public BalcaoDTO() {}

    public BalcaoDTO(Long id, List chamados,Long atendenteId) {
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

    public List getChamados() {
        return chamados;
    }

    public void setChamados(List chamados) {
        this.chamados = chamados;
    }

    public Long getAtendenteId() {
        return atendenteId;
    }

    public void setAtendenteId(Long atendenteId) {
        this.atendenteId = atendenteId;
    }
}
