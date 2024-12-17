package com.example.demo.Service;

import com.example.demo.Exception.AtendenteNaoEncontradoException;
import com.example.demo.Exception.AtendenteNãoSalvoException;
import com.example.demo.Model.Atendente;
import com.example.demo.Model.Balcao;
import com.example.demo.Repository.AtendenteRepository;
import com.example.demo.Repository.BalcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            throw new AtendenteNãoSalvoException("Erro ao salvar o balcao"); // Trocar Por uma exception de balcao.
        }
    }

    public Balcao buscarBalcaoPorId(Long id) {
        return balcaoRepository.findById(id)
                .orElseThrow(() -> new AtendenteNaoEncontradoException("Atendente com ID " + id + " não encontrado")); // Trocar Por uma exception de balcao
    }
}
