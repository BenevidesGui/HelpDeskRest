package com.example.demo.Controller;

import com.example.demo.DTO.BalcaoDTO;
import com.example.demo.Mapper.BalcaoMapper;
import com.example.demo.Model.Balcao;
import com.example.demo.Service.BalcaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balcao")
@Tag(name = "Balcao")
public class BalcaoController {

    @Autowired()
    private BalcaoService balcaoService;

    @PostMapping()
    @Operation(summary = "Criar  Balcao")
    public ResponseEntity<BalcaoDTO> salvarBalcao (@RequestBody BalcaoDTO dto){
        Balcao balcao = BalcaoMapper.toEntity(dto);
        BalcaoDTO responseDto = BalcaoMapper.toDTO(balcaoService.criarBalcao(balcao));
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID do Balcao")
    public ResponseEntity<BalcaoDTO> buscarBalcao (@PathVariable Long id){
        Balcao balcaoEncontrado = balcaoService.buscarBalcaoPorId(id);
        BalcaoDTO dto = BalcaoMapper.toDTO(balcaoEncontrado);
        return ResponseEntity.ok(dto);
    }
}
