package com.example.demo.Service;
import com.example.demo.DTO.AtendenteDTO;
import com.example.demo.DTO.ChamadoDTO;
import com.example.demo.Exception.BalcaoException.BalcaoNaoEncontradoException;
import com.example.demo.Exception.ChamadoException.ChamadoNaoEditadoException;
import com.example.demo.Exception.ChamadoException.ChamadoNaoEncontradoException;
import com.example.demo.Exception.ChamadoException.ChamadoNaoFechadoException;
import com.example.demo.Exception.ChamadoException.LimiteDeChamadosExcedidoException;
import com.example.demo.Exception.MaquinaException.MaquinaNaoEncontradaException;
import com.example.demo.Mapper.ChamadoMapper;
import com.example.demo.Model.Balcao;
import com.example.demo.Model.Chamado;
import com.example.demo.Model.Maquina;
import com.example.demo.Repository.BalcaoRepository;
import com.example.demo.Repository.ChamadoRepository;
import com.example.demo.Repository.MaquinaRepository;
import com.example.demo.StatusChamado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

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
                    .orElseThrow(() -> new MaquinaNaoEncontradaException("Máquina não encontrada com o ID: " + chamado.getMaquina().getDeviceId()));
            chamado.setMaquina(maquina);
        }

        Balcao balcao = balcaoRepository.findById(chamado.getBalcao().getId())
                .orElseThrow(() -> new BalcaoNaoEncontradoException("Balcao não encontrado com o ID: " + chamado.getBalcao().getId()));

        long countChamados = chamadoRepository.countByBalcaoId(balcao.getId());
        if (countChamados >= 5) {
            throw new LimiteDeChamadosExcedidoException("O balcão já possui 5 chamados e não pode aceitar mais.");
        }
        return chamadoRepository.save(chamado);
    }

    public ChamadoDTO buscarChamadoPorId(Long id) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new ChamadoNaoEncontradoException("Chamado com ID " + id + " não encontrado"));
        ChamadoDTO chamadoDTO = ChamadoMapper.toDTO(chamado);
        chamadoDTO.setBalcaoId(chamadoDTO.getBalcaoId());
        return chamadoDTO;
    }

    public Chamado fecharChamado(Long id) {

            Chamado chamado = chamadoRepository.findById(id)
                    .orElseThrow(() -> new ChamadoNaoEncontradoException("Chamado com ID " + id + " não encontrado"));
            chamado.setStatus(StatusChamado.FECHADO);

        try{
            return chamadoRepository.save(chamado);
        }catch (Exception ex){
            throw new ChamadoNaoFechadoException("Erro ao Fechar o chamado");
        }
    }

    public Chamado editarChamado(String motivo, Long id){
            Chamado chamadoAtual = chamadoRepository.findById(id)
                    .orElseThrow(() -> new ChamadoNaoEncontradoException("Chamado com ID " + id + " não encontrado"));
            chamadoAtual.setDataChamado(LocalDate.now());
            chamadoAtual.setMotivo(motivo);

        try{
            return chamadoRepository.save(chamadoAtual);
        }catch (Exception ex){
            throw new ChamadoNaoEditadoException("Erro ao Editar o chamado");
        }
    }

    public Page<ChamadoDTO> buscarChamadosPaginados(int pagina, int tamanho){
        return chamadoRepository.findAllChamados(PageRequest.of(pagina, tamanho));
    }

}
