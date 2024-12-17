package com.example.demo.Service;

import com.example.demo.Exception.AtendendeNaoEditadoException;
import com.example.demo.Exception.AtendenteNaoDeletado;
import com.example.demo.Exception.AtendenteNaoEncontradoException;
import com.example.demo.Exception.AtendenteNãoSalvoException;
import com.example.demo.Model.Atendente;
import com.example.demo.Repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AtendenteService {

    @Autowired
    private AtendenteRepository atendenteRepository;

    public Atendente buscarAtendentePorId(Long id) {
        return atendenteRepository.findById(id)
                .orElseThrow(() -> new AtendenteNaoEncontradoException("Atendente com ID " + id + " não encontrado"));
    }

    public Atendente salvarAtendente (Atendente atendente){
        try {
            atendente.setNumMatricula(matricula());
            return atendenteRepository.save(atendente);
        } catch (Exception ex) {
            throw new AtendenteNãoSalvoException("Erro ao salvar o atendente");
        }
    }

    public Atendente editarAtendente(Atendente atendente, Long id){
        try {
            atendenteRepository.findById(id);
            atendente.setId(id);
            return atendenteRepository.save(atendente);
        }catch (Exception ex){
            throw new AtendendeNaoEditadoException("Erro ao Editar o atendente");
        }
    }

    public Atendente editarAtendentePatch(Atendente atendente, Long id) {
        Optional<Atendente> findAtendenteOpt = atendenteRepository.findById(id);
        Atendente findAtendente = findAtendenteOpt.orElseThrow(() ->
                new AtendenteNaoEncontradoException("Atendente com ID " + id + " não encontrado")
        );

        if (atendente.getNomeAtendente() != null) {
            findAtendente.setNomeAtendente(atendente.getNomeAtendente());
        }
        if (atendente.getNumMatricula() != null) {
            findAtendente.setNumMatricula(atendente.getNumMatricula());
        }

        return atendenteRepository.save(findAtendente);
    }

    public void deletarAtendente(Long id){
        try {
            atendenteRepository.findById(id);
            atendenteRepository.deleteById(id);
        }catch (Exception ex){
            throw new AtendenteNaoDeletado("Erro ao Deletar o atendente");
        }
    }
    public String matricula() {
        Random random = new Random();
        String prefixo = "BR";
        int numeroInteiroLimite = random.nextInt(9999 - 1000 + 1) + 1000;
        return prefixo + numeroInteiroLimite;
    }

}