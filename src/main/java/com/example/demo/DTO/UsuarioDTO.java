package com.example.demo.DTO;
import com.example.demo.Views.View;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class UsuarioDTO {

    @JsonView(View.UserView.class)
    private Long id;
    @JsonView(View.UserView.class)
    private String nome;
    @JsonView(View.UserView.class)
    private String email;
    @JsonView(View.UserView.class)
    private List<MaquinaDTO> maquinas;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MaquinaDTO> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(List<MaquinaDTO> maquinas) {
        this.maquinas = maquinas;
    }
}
