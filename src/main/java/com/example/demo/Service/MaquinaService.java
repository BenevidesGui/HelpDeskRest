package com.example.demo.Service;

import com.example.demo.Model.Maquina;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaquinaService {

    @Autowired
    private MaquinaRepository maquinaRepository;
    private UsuarioService usuarioService;

    public Maquina criarMaquina(Maquina maquina) {
        if (maquina.getUsuario() != null && maquina.getUsuario().getId() != null) {
            Usuario usuario = usuarioService.consultarUsuarioPorId(maquina.getUsuario().getId());
            maquina.setUsuario(usuario);
        } else {
            throw new RuntimeException("Usuário não fornecido ou inválido");
        }

        return maquinaRepository.save(maquina);
    }

    public Maquina consultarMaquinaPorDeviceId(Long deviceId) {
        return maquinaRepository.findByDeviceId(deviceId)
                .orElseThrow(() -> new RuntimeException("Máquina não encontrada para o deviceId: " + deviceId));
    }
}
