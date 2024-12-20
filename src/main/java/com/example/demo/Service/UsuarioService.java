package com.example.demo.Service;

import com.example.demo.Model.Usuario;
import com.example.demo.DTO.UsuarioDTO;
import com.example.demo.Mapper.UsuarioMapper;
import com.example.demo.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    public Usuario consultarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado para o ID: " + id));
    }
}
