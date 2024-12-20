package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;


@Entity
public class Balcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "balcao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Chamado> chamados;

    @OneToOne
    @JoinColumn(name = "atendente_id", referencedColumnName = "id", nullable = false)
    private Atendente atendente;

    public Balcao() {}

    public Balcao(List<Chamado> chamados, Atendente atendente) {
        this.chamados = chamados;
        this.atendente = atendente;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }
}
