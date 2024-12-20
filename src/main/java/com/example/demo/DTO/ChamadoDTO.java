package com.example.demo.DTO;

import com.example.demo.StatusChamado;

import java.time.LocalDate;

public class ChamadoDTO {

    private Long id;
    private Long balcaoId;
    private Long usuarioId;
    private LocalDate dataChamado;
    private LocalDate dataResolucao;
    private Long deviceId;
    private Long customerId;
    private String motivo;
    private StatusChamado status;

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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
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
