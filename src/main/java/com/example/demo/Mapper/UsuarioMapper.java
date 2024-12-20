package com.example.demo.Mapper;

import com.example.demo.DTO.MaquinaDTO;
import com.example.demo.Model.Maquina;
import com.example.demo.Model.Usuario;
import com.example.demo.DTO.UsuarioDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public static UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());

        List<MaquinaDTO> maquinasDTO = usuario.getMaquinas().stream()
                .map(maquina -> {
                    MaquinaDTO maquinaDTO = new MaquinaDTO();
                    maquinaDTO.setDeviceId(maquina.getDeviceId());
                    maquinaDTO.setSerialNumber(maquina.getSerialNumber());
                    return maquinaDTO;
                })
                .collect(Collectors.toList());

        dto.setMaquinas(maquinasDTO);
        return dto;
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        List<Maquina> maquinas = dto.getMaquinas().stream()
                .map(maquinaDTO -> {
                    Maquina maquina = new Maquina();
                    maquina.setDeviceId(maquinaDTO.getDeviceId()); // Adicionado caso o ID já exista
                    maquina.setSerialNumber(maquinaDTO.getSerialNumber());
                    maquina.setUsuario(usuario); // Configurando a associação bidirecional
                    return maquina;
                })
                .collect(Collectors.toList());

        usuario.setMaquinas(maquinas);
        return usuario;
    }
}
