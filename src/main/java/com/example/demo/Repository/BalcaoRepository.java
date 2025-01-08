package com.example.demo.Repository;
import com.example.demo.DTO.BalcaoDTO;
import com.example.demo.DTO.ChamadoDTO;
import com.example.demo.Model.Balcao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BalcaoRepository extends JpaRepository<Balcao, Long> {
    @Query("SELECT new com.example.demo.DTO.BalcaoDTO( " +
            "b.id, " +
            "b.atendente.id) " +
            "FROM Balcao b")
    Page<BalcaoDTO> findAllBalcao(Pageable pageable);
}
