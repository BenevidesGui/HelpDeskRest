package com.example.demo.Service;

import com.example.demo.Exception.UsuarioException.UsuarioNaoCriadoException;
import com.example.demo.Exception.UsuarioException.UsuarioNaoDeletadoException;
import com.example.demo.Exception.UsuarioException.UsuarioNaoEditadoException;
import com.example.demo.Exception.UsuarioException.UsuarioNaoEncontradoException;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        }catch (UsuarioNaoCriadoException e){
            throw new UsuarioNaoCriadoException("Usuário não foi criado");
        }
    }


    public Usuario consultarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado para o ID: " + id));
    }

    public Usuario editarUsuario(Long id, String nome, String email){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado para o ID: " + id));

        usuario.setNome(nome);
        usuario.setEmail(email);

        try {
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new UsuarioNaoEditadoException("Erro ao editar o usuário: " + e.getMessage());
        }
    }
    public void deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado para o ID: " + id));

        try {
            usuarioRepository.delete(usuario);
        } catch (Exception e) {
            throw new UsuarioNaoDeletadoException("Erro ao deletar o usuário: " + e.getMessage());
        }
    }
}
