package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
public class Atendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nomeAtendente;

    @NotNull
    private String numMatricula;

    @OneToOne(mappedBy = "atendente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Balcao balcao;

    public Atendente() {}

    public Atendente(String nomeAtendente, String numMatricula) {
        this.nomeAtendente = nomeAtendente;
        this.numMatricula = numMatricula;
    }

    //getters e setters
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

    public Balcao getBalcao() {
        return balcao;
    }

    public void setBalcao(Balcao balcao) {
        this.balcao = balcao;
    }
}
