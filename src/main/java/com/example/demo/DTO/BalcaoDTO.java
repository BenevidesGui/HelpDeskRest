package com.example.demo.DTO;


import com.example.demo.Views.View;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class BalcaoDTO {

    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ChamadoDTO> chamados;
    private Long atendenteId;

    public BalcaoDTO() {}

    public BalcaoDTO(Long id, List<ChamadoDTO>  chamados,Long atendenteId) {
        this.id = id;
        this.chamados = chamados;
        this.atendenteId = atendenteId;
    }

    public BalcaoDTO(Long id, Long atendenteId) {
        this.id = id;
        this.atendenteId = atendenteId;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonView(View.BalcaoView.class)
    public List<ChamadoDTO>  getChamados() {
        return chamados;
    }

    public void setChamados(List<ChamadoDTO> chamados) {
        this.chamados = chamados;
    }

    public Long getAtendenteId() {
        return atendenteId;
    }

    public void setAtendenteId(Long atendenteId) {
        this.atendenteId = atendenteId;
    }
}
