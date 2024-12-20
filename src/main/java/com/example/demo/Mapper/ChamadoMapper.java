package com.example.demo.Mapper;

import com.example.demo.DTO.ChamadoDTO;
import com.example.demo.Model.Balcao;
import com.example.demo.Model.Chamado;
import com.example.demo.Model.Maquina;
import com.example.demo.Model.Usuario;

public class ChamadoMapper {

    public static Chamado toEntity(ChamadoDTO dto) {
        Chamado chamado = new Chamado();

        if (dto.getBalcaoId() != null) {
            Balcao balcao = new Balcao();
            balcao.setId(dto.getBalcaoId());
            chamado.setBalcao(balcao);
        }

        if (dto.getDeviceId() != null) {
            Maquina maquina = new Maquina();
            maquina.setDeviceId(dto.getDeviceId());
            chamado.setMaquina(maquina);
        }

        if (dto.getCustomerId() != null) {
            Usuario usuario = new Usuario();
            usuario.setId(dto.getCustomerId());
            chamado.setUsuario(usuario);
        }

        chamado.setId(dto.getId());
        chamado.setDataChamado(dto.getDataChamado());
        chamado.setDataResolucao(dto.getDataResolucao());
        chamado.setMotivo(dto.getMotivo());
        chamado.setStatus(dto.getStatus());

        return chamado;
    }

    public static ChamadoDTO toDTO(Chamado chamado) {
        ChamadoDTO dto = new ChamadoDTO();
        dto.setId(chamado.getId());
        dto.setDataChamado(chamado.getDataChamado());
        dto.setDataResolucao(chamado.getDataResolucao());
        dto.setMotivo(chamado.getMotivo());
        dto.setStatus(chamado.getStatus());

        dto.setDeviceId(chamado.getMaquina() != null ? chamado.getMaquina().getDeviceId() : null);
        dto.setBalcaoId(chamado.getBalcao() != null ? chamado.getBalcao().getId() : null);
        dto.setCustomerId(chamado.getUsuario() != null ? chamado.getUsuario().getId() : null);

        return dto;
    }
}
