package com.example.demo.Controller;

import com.example.demo.DTO.ChamadoDTO;
import com.example.demo.Exception.ChamadoException.ChamadoNaoEncontradoException;
import com.example.demo.Exception.ChamadoException.ChamadoNaoFechadoException;
import com.example.demo.Mapper.ChamadoMapper;
import com.example.demo.Model.Chamado;
import com.example.demo.Service.ChamadoService;
import com.example.demo.Views.View;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @JsonView(View.ChamadoView.class)
    @Operation(summary = "Buscar chamado por ID")
    public ResponseEntity<ChamadoDTO> buscarChamadoPorId(@PathVariable Long id) {
        try {
            ChamadoDTO chamado = chamadoService.buscarChamadoPorId(id);
            return ResponseEntity.ok(chamado);
        } catch (ChamadoNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping()
    public Page<ChamadoDTO> buscarChamadosPaginados(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho) {

        return chamadoService.buscarChamadosPaginados(pagina, tamanho);
    }

    @PatchMapping("/{id}")
    @JsonView(View.ChamadoView.class)
    @Operation(summary = "Fechar Chamado")
    public ResponseEntity<ChamadoDTO> fecharChamado(@PathVariable Long id) {
        try {
            ChamadoDTO chamado = chamadoService.buscarChamadoPorId(id);
            Chamado chamadoFechado = chamadoService.fecharChamado(chamado.getId());
            ChamadoDTO responseDTO = ChamadoMapper.toDTO(chamadoFechado);
            return ResponseEntity.ok(responseDTO);
        }catch (ChamadoNaoFechadoException ex) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }

    @PutMapping("/{id}")
    @JsonView(View.ChamadoView.class)
    @Operation(summary = "Editar Chamado")
    public ResponseEntity<ChamadoDTO> editarChamado(@RequestBody Map<String, String> payload, @PathVariable Long id) {
        try {
            String motivo = payload.get("motivo");
            Chamado chamadoEditado = chamadoService.editarChamado(motivo,id);
            ChamadoDTO responseDTO = ChamadoMapper.toDTO(chamadoEditado);
            return ResponseEntity.ok(responseDTO);
        }catch (ChamadoNaoFechadoException ex) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }


}
