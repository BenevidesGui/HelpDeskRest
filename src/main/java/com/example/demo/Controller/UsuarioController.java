package com.example.demo.Controller;

import com.example.demo.DTO.UsuarioDTO;
import com.example.demo.Exception.UsuarioException.UsuarioNaoCriadoException;
import com.example.demo.Exception.UsuarioException.UsuarioNaoDeletadoException;
import com.example.demo.Exception.UsuarioException.UsuarioNaoEncontradoException;
import com.example.demo.Mapper.UsuarioMapper;
import com.example.demo.Model.Usuario;
import com.example.demo.Service.UsuarioService;
import com.example.demo.Views.View;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper usuarioMapper;


    @PostMapping
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
            Usuario usuarioSalvo = usuarioService.criarUsuario(usuario);
            UsuarioDTO usuarioDTOResponse = usuarioMapper.toDTO(usuarioSalvo);
            return ResponseEntity.ok(usuarioDTOResponse);
        }catch (UsuarioNaoCriadoException e){
            throw e;
        }
    }

    @GetMapping("/{id}")
    @JsonView(View.UserView.class)
    public ResponseEntity<UsuarioDTO> consultarUsuarioPorId(@PathVariable Long id) {
        try {
            Usuario usuario = usuarioService.consultarUsuarioPorId(id);
            UsuarioDTO usuarioDTOResponse = usuarioMapper.toDTO(usuario);
            return ResponseEntity.ok(usuarioDTOResponse);
        }catch (UsuarioNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar Usuário")
    public ResponseEntity<Usuario> editarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        try {
            Usuario usuarioEditado = usuarioService.editarUsuario(id, usuario.getNome(), usuario.getEmail());
            return ResponseEntity.ok(usuarioEditado);
        } catch (UsuarioNaoDeletadoException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }

    // Deletar usuário
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Usuário")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        try {
            usuarioService.deletarUsuario(id);
            return ResponseEntity.noContent().build();
        } catch (UsuarioNaoDeletadoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
