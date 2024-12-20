package com.example.demo.Repository;

import com.example.demo.Model.Chamado;
import com.example.demo.Model.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MaquinaRepository extends JpaRepository<Maquina, Long> {
    Optional<Maquina> findByDeviceId(Long deviceId);
}
