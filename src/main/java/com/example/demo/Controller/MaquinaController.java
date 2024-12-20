package com.example.demo.Controller;

import com.example.demo.DTO.MaquinaDTO;
import com.example.demo.Mapper.MaquinaMapper;
import com.example.demo.Model.Maquina;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.MaquinaRepository;
import com.example.demo.Service.MaquinaService;
import com.example.demo.Service.UsuarioService;
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
    public ResponseEntity<Maquina> consultarMaquina(@PathVariable Long deviceId) {
        try {
            Maquina maquina = maquinaService.consultarMaquinaPorDeviceId(deviceId);
            return ResponseEntity.ok(maquina);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
