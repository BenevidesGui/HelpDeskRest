package com.example.demo.Repository;

import com.example.demo.DTO.AtendenteDTO;
import com.example.demo.Model.Atendente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AtendenteRepository extends CrudRepository<Atendente,Long> {
    @Query("SELECT new com.example.demo.DTO.AtendenteDTO(atendente.id, atendente.nomeAtendente, atendente.numMatricula) " +
            "FROM Atendente atendente")
    Page<AtendenteDTO> findAllAtendentes(Pageable pageable);
}
