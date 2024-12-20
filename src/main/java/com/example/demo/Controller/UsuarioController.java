package com.example.demo.Controller;

import com.example.demo.DTO.UsuarioDTO;
import com.example.demo.Mapper.UsuarioMapper;
import com.example.demo.Model.Usuario;
import com.example.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper usuarioMapper;


    @PostMapping
    public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        Usuario usuarioSalvo = usuarioService.criarUsuario(usuario);
        UsuarioDTO usuarioDTOResponse = usuarioMapper.toDTO(usuarioSalvo);
        return ResponseEntity.ok(usuarioDTOResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> consultarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.consultarUsuarioPorId(id);
        UsuarioDTO usuarioDTOResponse = usuarioMapper.toDTO(usuario);
        return ResponseEntity.ok(usuarioDTOResponse);
    }
}
