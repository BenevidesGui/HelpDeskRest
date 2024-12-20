package com.example.demo.Repository;

import com.example.demo.Model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
    long countByBalcaoId(Long balcaoId);
}
