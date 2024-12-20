package com.example.demo.Mapper;

import com.example.demo.DTO.MaquinaDTO;
import com.example.demo.Model.Maquina;
import com.example.demo.Model.Usuario;
import com.example.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MaquinaMapper {
    @Autowired
    private UsuarioService usuarioService;

    public MaquinaDTO toDTO(Maquina maquina) {
        MaquinaDTO dto = new MaquinaDTO();
        dto.setDeviceId(maquina.getDeviceId());
        dto.setSerialNumber(maquina.getSerialNumber());

        // Adiciona o customerId do usuário associado à máquina
        if (maquina.getUsuario() != null) {
            dto.setCustomerId(maquina.getUsuario().getId());
        }

        return dto;
    }

    public Maquina toEntity(MaquinaDTO dto) {
        Maquina maquina = new Maquina();
        maquina.setDeviceId(dto.getDeviceId());
        maquina.setSerialNumber(dto.getSerialNumber());
        return maquina;
    }
}
