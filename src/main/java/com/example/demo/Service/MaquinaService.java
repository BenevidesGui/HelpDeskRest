package com.example.demo.Service;

import com.example.demo.Exception.MaquinaException.*;
import com.example.demo.Exception.UsuarioException.UsuarioNaoCriadoException;
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
            throw new UsuarioNaoFornecidoOuInvalidoException("Usuário não fornecido ou inválido");
        }

        try {
            return maquinaRepository.save(maquina);
        } catch (Exception e) {
            throw new MaquinaNaoCriadaException("Máquina não criada devido a erro de persistência");
        }

    }

    public Maquina consultarMaquinaPorDeviceId(Long deviceId) {
        return maquinaRepository.findByDeviceId(deviceId)
                .orElseThrow(() -> new MaquinaNaoEncontradaException("Máquina não encontrada para o deviceId: " + deviceId));
    }

    public Maquina editarMaquina(Long deviceId, Maquina maquinaAtualizada) {

        Maquina maquinaExistente = maquinaRepository.findByDeviceId(deviceId)
                .orElseThrow(() -> new MaquinaNaoEncontradaException("Máquina não encontrada para o deviceId: " + deviceId));

        if (maquinaAtualizada.getSerialNumber() != null) {
            maquinaExistente.setSerialNumber(maquinaAtualizada.getSerialNumber());
        }

        try {
            return maquinaRepository.save(maquinaExistente);
        } catch (Exception e) {
            throw new MaquinaNaoEditadaException("Máquina não editada devido a erro de persistência");
        }
    }

    public void deletarMaquina(Long deviceId) {
        Maquina maquina = maquinaRepository.findById(deviceId)
                .orElseThrow(() -> new MaquinaNaoEncontradaException("Máquina não encontrada com deviceId: " + deviceId));

        try {
            maquinaRepository.delete(maquina);
        } catch (Exception e) {
            throw new MaquinaNaoDeletadaException("Máquina não deletada devido a erro de persistência");
        }
    }
}
