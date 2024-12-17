package com.example.demo.Controller;

import com.example.demo.DTO.AtendenteDTO;
import com.example.demo.Mapper.AtendenteMapper;
import com.example.demo.Model.Atendente;
import com.example.demo.Service.AtendenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atendente")
@Tag(name = "Atendente")
public class AtendenteController {

    @Autowired()
    private AtendenteService atendenteService;


    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID do Atendente")
    public ResponseEntity<AtendenteDTO> buscarAtendente(@PathVariable Long id){
        Atendente atendenteEncontrado = atendenteService.buscarAtendentePorId(id);
        AtendenteDTO dto = AtendenteMapper.toDTO(atendenteEncontrado);
        return ResponseEntity.ok(dto);
    }

    @PostMapping()
    @Operation(summary = "Salvar Atendente")
    public ResponseEntity<AtendenteDTO> salvarAtendente (@RequestBody AtendenteDTO dto){
        Atendente atendente = AtendenteMapper.toEntity(dto);
        AtendenteDTO responseDto = AtendenteMapper.toDTO(atendenteService.salvarAtendente(atendente));
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar Atendente")
    public ResponseEntity<AtendenteDTO> editarAtendente (@RequestBody AtendenteDTO dto,@PathVariable Long id){
        Atendente atendente = AtendenteMapper.toEntity(dto);
        AtendenteDTO responseDto = AtendenteMapper.toDTO(atendenteService.editarAtendente(atendente,id));
        return ResponseEntity.ok(responseDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Editar Atendente")
    public ResponseEntity<AtendenteDTO> editarAtendentePatch (@RequestBody AtendenteDTO dto,@PathVariable Long id){
        Atendente atendente = AtendenteMapper.toEntity(dto);
        AtendenteDTO responseDto = AtendenteMapper.toDTO(atendenteService.editarAtendentePatch(atendente,id));
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Atendente")
    public ResponseEntity<AtendenteDTO> deletarAtendente(@PathVariable Long id) {
        Atendente atendente = atendenteService.buscarAtendentePorId(id);
        atendenteService.deletarAtendente(id);
        AtendenteDTO dto = AtendenteMapper.toDTO(atendente);
        return ResponseEntity.ok(dto);
    }
}
