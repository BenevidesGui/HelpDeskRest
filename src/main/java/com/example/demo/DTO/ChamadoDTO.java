package com.example.demo.DTO;

import com.example.demo.StatusChamado;
import com.example.demo.Views.View;
import com.fasterxml.jackson.annotation.JsonView;

import java.time.LocalDate;

public class ChamadoDTO {

    @JsonView({View.ChamadoView.class, View.BalcaoView.class})
    private Long id;
    @JsonView(View.ChamadoView.class)
    private Long balcaoId;
    @JsonView({View.ChamadoView.class, View.BalcaoView.class})
    private LocalDate dataChamado;
    @JsonView({View.ChamadoView.class, View.BalcaoView.class})
    private LocalDate dataResolucao;
    @JsonView({View.ChamadoView.class, View.BalcaoView.class})
    private Long deviceId;
    @JsonView({View.ChamadoView.class, View.BalcaoView.class})
    private Long customerId;
    @JsonView({View.ChamadoView.class, View.BalcaoView.class})
    private String motivo;
    @JsonView({View.ChamadoView.class, View.BalcaoView.class})
    private StatusChamado status;

    public ChamadoDTO() {
    }
    public ChamadoDTO(Long id, Long balcaoId, LocalDate dataChamado, LocalDate dataResolucao, Long deviceId, Long customerId, String motivo, StatusChamado status) {
        this.id = id;
        this.balcaoId = balcaoId;
        this.dataChamado = dataChamado;
        this.dataResolucao = dataResolucao;
        this.deviceId = deviceId;
        this.customerId = customerId;
        this.motivo = motivo;
        this.status = status;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBalcaoId() {
        return balcaoId;
    }

    public void setBalcaoId(Long balcaoId) {
        this.balcaoId = balcaoId;
    }


    public LocalDate getDataChamado() {
        return dataChamado;
    }

    public void setDataChamado(LocalDate dataChamado) {
        this.dataChamado = dataChamado;
    }

    public LocalDate getDataResolucao() {
        return dataResolucao;
    }

    public void setDataResolucao(LocalDate dataResolucao) {
        this.dataResolucao = dataResolucao;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public void setStatus(StatusChamado status) {
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
