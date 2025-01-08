package com.example.demo.Mapper;

import com.example.demo.DTO.BalcaoDTO;
import com.example.demo.DTO.ChamadoDTO;
import com.example.demo.Model.Atendente;
import com.example.demo.Model.Balcao;
import com.example.demo.Model.Chamado;
import com.example.demo.Model.Maquina;

import java.util.List;
import java.util.stream.Collectors;

public class BalcaoMapper {

    public static BalcaoDTO toDTO(Balcao balcao) {
        if (balcao == null) {
            return null;
        }

        java.util.List<ChamadoDTO> chamadoDTOs = balcao.getChamados().stream()
                .map(chamado -> {
                    ChamadoDTO dto = new ChamadoDTO();
                    dto.setId(chamado.getId());
                    dto.setCustomerId(chamado.getUsuario() != null ? chamado.getUsuario().getId() : null);
                    dto.setDataChamado(chamado.getDataChamado());
                    dto.setDataResolucao(chamado.getDataResolucao());
                    dto.setDeviceId(chamado.getMaquina() != null ? chamado.getMaquina().getDeviceId() : null);
                    dto.setMotivo(chamado.getMotivo());
                    dto.setStatus(chamado.getStatus());
                    return dto;
                })
                .collect(Collectors.toList());

        return new BalcaoDTO(
                balcao.getId(),
                chamadoDTOs,
                balcao.getAtendente() != null ? balcao.getAtendente().getId() : null
        );
    }

    public static Balcao toEntity(BalcaoDTO dto) {
        if (dto == null) {
            return null;
        }

        Balcao balcao = new Balcao();

        // Converter ChamadoDTO para Chamado, se necessário
        if (dto.getChamados() != null) {
            List<Chamado> chamados = dto.getChamados().stream()
                    .map(chamadoDTO -> {
                        Chamado chamado = new Chamado();
                        chamado.setId(chamadoDTO.getId());
                        return chamado;
                    })
                    .collect(Collectors.toList());
            balcao.setChamados(chamados);
        }

        if (dto.getAtendenteId() != null) {
            Atendente atendente = new Atendente();
            atendente.setId(dto.getAtendenteId());
            balcao.setAtendente(atendente);
        }

        return balcao;
    }
}
