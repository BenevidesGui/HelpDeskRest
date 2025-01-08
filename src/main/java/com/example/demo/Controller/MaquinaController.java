package com.example.demo.Controller;

import com.example.demo.DTO.MaquinaDTO;
import com.example.demo.Mapper.MaquinaMapper;
import com.example.demo.Model.Maquina;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.MaquinaRepository;
import com.example.demo.Service.MaquinaService;
import com.example.demo.Service.UsuarioService;
import com.example.demo.Views.View;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maquina")
public class MaquinaController {

    @Autowired
    private MaquinaService maquinaService;

    @Autowired
    private MaquinaRepository maquinaRepository;

    @Autowired
    private MaquinaMapper maquinaMapper;

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Maquina criarMaquina(@RequestBody MaquinaDTO maquinaDTO) {
        Maquina maquina = maquinaMapper.toEntity(maquinaDTO);

        if (maquinaDTO.getCustomerId() != null) {
            Usuario usuario = usuarioService.consultarUsuarioPorId(maquinaDTO.getCustomerId());
            maquina.setUsuario(usuario);
        }
        return maquinaRepository.save(maquina);
    }

    @GetMapping("/{deviceId}")
    @JsonView(View.MaquinaView.class)
    public ResponseEntity<MaquinaDTO> consultarMaquina(@PathVariable Long deviceId) {
        try {
            Maquina maquina = maquinaService.consultarMaquinaPorDeviceId(deviceId);
            MaquinaDTO maquinaDTO = maquinaMapper.toDTO(maquina);
            return ResponseEntity.ok(maquinaDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{deviceId}")
    @Operation(summary = "Editar Máquina")
    @JsonView(View.MaquinaView.class)  // Usando a view para controlar a serialização
    public ResponseEntity<MaquinaDTO> editarMaquina(@PathVariable Long deviceId, @RequestBody MaquinaDTO maquinaDTO) {
        try {
            Maquina maquinaParaEditar = maquinaMapper.toEntity(maquinaDTO);
            maquinaParaEditar.setDeviceId(deviceId);
            Maquina maquinaEditada = maquinaService.editarMaquina(deviceId, maquinaParaEditar);
            MaquinaDTO responseDTO = maquinaMapper.toDTO(maquinaEditada);

            return ResponseEntity.ok(responseDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{deviceId}")
    @Operation(summary = "Deletar Máquina")
    public ResponseEntity<Void> deletarMaquina(@PathVariable Long deviceId) {
        try {
            maquinaService.deletarMaquina(deviceId);

            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
