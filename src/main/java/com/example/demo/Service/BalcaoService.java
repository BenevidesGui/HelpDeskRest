package com.example.demo.Service;

import com.example.demo.Exception.AtendenteException.AtendenteNaoEncontradoException;
import com.example.demo.Exception.BalcaoException.BalcaoNaoEditadoException;
import com.example.demo.Exception.BalcaoException.BalcaoNaoEncontradoException;
import com.example.demo.Exception.BalcaoException.BalcaoNaoSalvoException;
import com.example.demo.Model.Atendente;
import com.example.demo.Model.Balcao;
import com.example.demo.Repository.BalcaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalcaoService {

    @Autowired
    private BalcaoRepository balcaoRepository;

    @Autowired
    private AtendenteService atendenteService;

    public Balcao criarBalcao(Balcao balcao) {
        try {
            Atendente atendenteValidado = atendenteService.buscarAtendentePorId(balcao.getAtendente().getId());
            balcao.setAtendente(atendenteValidado);
            return balcaoRepository.save(balcao);
        } catch (AtendenteNaoEncontradoException ex) {
            throw new AtendenteNaoEncontradoException("Erro ao validar atendente: " + ex.getMessage());
        } catch (Exception ex) {
            throw new BalcaoNaoSalvoException("Erro ao salvar o balcao");
        }
    }

    public Balcao buscarBalcaoPorId(Long id) {
            return balcaoRepository.findById(id)
                    .orElseThrow(() -> new BalcaoNaoEncontradoException("Balcao com ID " + id + " não encontrado"));
    }

    public Balcao editarBalcao(Balcao balcao, Long id){
        try {
            Balcao balcaoExistente = buscarBalcaoPorId(id);
            Atendente atendenteValidado = atendenteService.buscarAtendentePorId(balcao.getAtendente().getId());
            balcao.setAtendente(atendenteValidado);
            balcao.setId(id);
            return balcaoRepository.save(balcao);
        } catch (AtendenteNaoEncontradoException ex) {
            throw new AtendenteNaoEncontradoException("Erro ao validar atendente: " + ex.getMessage());
        } catch (Exception ex) {
            throw new BalcaoNaoEditadoException("Erro ao salvar o balcao");
        }
    }

    @Transactional
    public void deleteBalcao(Long id) {
        Balcao balcao = balcaoRepository.findById(id)
                .orElseThrow(() -> new BalcaoNaoEncontradoException("Balcao não encontrado com ID: " + id));
        Atendente atendente = balcao.getAtendente();
        if (atendente != null) {
            atendente.setBalcao(null);
        }
        balcaoRepository.delete(balcao);
    }
}
