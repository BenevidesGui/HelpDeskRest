package com.example.demo.Service;
import com.example.demo.Exception.ChamadoException.ChamadoNaoEncontradoException;
import com.example.demo.Exception.ChamadoException.LimiteDeChamadosExcedidoException;
import com.example.demo.Model.Balcao;
import com.example.demo.Model.Chamado;
import com.example.demo.Model.Maquina;
import com.example.demo.Repository.BalcaoRepository;
import com.example.demo.Repository.ChamadoRepository;
import com.example.demo.Repository.MaquinaRepository;
import com.example.demo.StatusChamado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private BalcaoRepository balcaoRepository;
    @Autowired
    private MaquinaRepository maquinaRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public ChamadoService(ChamadoRepository chamadoRepository) {
        this.chamadoRepository = chamadoRepository;
    }

    @Transactional
    public Chamado criarChamado(Chamado chamado) {

        chamado.setStatus(chamado.getStatus() != null ? chamado.getStatus() : StatusChamado.ABERTO);

        if (chamado.getMaquina() != null && chamado.getMaquina().getDeviceId() != null) {
            Maquina maquina = maquinaRepository.findById(chamado.getMaquina().getDeviceId())
                    .orElseThrow(() -> new RuntimeException("Máquina não encontrada com o ID: " + chamado.getMaquina().getDeviceId()));
            chamado.setMaquina(maquina);
        }

        Balcao balcao = balcaoRepository.findById(chamado.getBalcao().getId())
                .orElseThrow(() -> new RuntimeException("Balcao não encontrado com o ID: " + chamado.getBalcao().getId()));  //mudar exception

        long countChamados = chamadoRepository.countByBalcaoId(balcao.getId());
        if (countChamados >= 5) {
            throw new LimiteDeChamadosExcedidoException("O balcão já possui 5 chamados e não pode aceitar mais.");
        }
        return chamadoRepository.save(chamado);
    }

    public Chamado buscarChamadoPorId(Long id) {
        return chamadoRepository.findById(id)
                .orElseThrow(() -> new ChamadoNaoEncontradoException("Chamado com ID " + id + " não encontrado"));
    }
}
