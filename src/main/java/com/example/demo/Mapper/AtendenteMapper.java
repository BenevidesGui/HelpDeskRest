package com.example.demo.Mapper;

import com.example.demo.DTO.AtendenteDTO;
import com.example.demo.Model.Atendente;

public class AtendenteMapper {
    public static AtendenteDTO toDTO(Atendente atendente) {
        return new AtendenteDTO(
                atendente.getId(),
                atendente.getNomeAtendente(),
                atendente.getNumMatricula()
        );
    }

    public static Atendente toEntity(AtendenteDTO dto) {
        return new Atendente(
                dto.getNomeAtendente(),
                dto.getNumMatricula()
        );
    }
}
