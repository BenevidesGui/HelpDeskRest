package com.example.demo.Repository;

import com.example.demo.DTO.ChamadoDTO;
import com.example.demo.Model.Chamado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
    @Query("SELECT new com.example.demo.DTO.ChamadoDTO( " +
            "c.id, c.balcao.id, c.dataChamado, c.dataResolucao, c.maquina.deviceId, c.usuario.id, c.motivo, c.status) " +
            "FROM Chamado c")
    Page<ChamadoDTO> findAllChamados(Pageable pageable);

    long countByBalcaoId(Long balcaoId);
}
