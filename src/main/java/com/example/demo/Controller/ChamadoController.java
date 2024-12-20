package com.example.demo.Controller;

import com.example.demo.DTO.ChamadoDTO;
import com.example.demo.Exception.ChamadoException.ChamadoNaoEncontradoException;
import com.example.demo.Mapper.ChamadoMapper;
import com.example.demo.Model.Chamado;
import com.example.demo.Service.ChamadoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @PostMapping
    @Operation(summary = "Criar um novo chamado")
    public ResponseEntity<ChamadoDTO> criarChamado(@RequestBody ChamadoDTO chamadoDTO) {
        Chamado chamado = ChamadoMapper.toEntity(chamadoDTO);
        Chamado chamadoCriado = chamadoService.criarChamado(chamado);
        ChamadoDTO responseDTO = ChamadoMapper.toDTO(chamadoCriado);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar chamado por ID")
    public ResponseEntity<ChamadoDTO> buscarChamadoPorId(@PathVariable Long id) {
        try {
            Chamado chamado = chamadoService.buscarChamadoPorId(id);
            ChamadoDTO responseDTO = ChamadoMapper.toDTO(chamado);
            return ResponseEntity.ok(responseDTO);
        } catch (ChamadoNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
