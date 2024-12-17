package com.example.demo.Repository;
import com.example.demo.Model.Balcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalcaoRepository extends JpaRepository<Balcao, Long> {

}
