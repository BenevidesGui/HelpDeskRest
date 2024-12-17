package com.example.demo.Mapper;

import com.example.demo.DTO.BalcaoDTO;
import com.example.demo.Model.Atendente;
import com.example.demo.Model.Balcao;

public class BalcaoMapper {

    public static BalcaoDTO toDTO(Balcao balcao) {
        if (balcao == null) {
            return null;
        }

        return new BalcaoDTO(
                balcao.getId(),
                balcao.getChamados(),
                balcao.getAtendente().getId()
        );
    }

    public static Balcao toEntity(BalcaoDTO dto) {
        if (dto == null) {
            return null;
        }

        Balcao balcao = new Balcao();
        balcao.setChamados(dto.getChamados());

        if (dto.getAtendenteId() != null) {
            Atendente atendente = new Atendente();
            atendente.setId(dto.getAtendenteId());
            balcao.setAtendente(atendente);
        }

        return balcao;
    }
}
