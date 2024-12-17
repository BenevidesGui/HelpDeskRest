package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;


@Entity
public class Balcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String chamados;

    @OneToOne
    @JoinColumn(name = "atendente_id", referencedColumnName = "id", nullable = false)
    private Atendente atendente;

    public Balcao() {}

    public Balcao(String chamados, Atendente atendente) {
        this.chamados = chamados;
        this.atendente = atendente;
    }

    //getters e setters
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

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }
}
