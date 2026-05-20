package com.gestao.estacionamento.service;

import com.gestao.estacionamento.model.Disponibilidade;
import com.gestao.estacionamento.repository.DisponibilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DisponibilidadeService {

    @Autowired
    private DisponibilidadeRepository repository;

    public Disponibilidade salvar(Disponibilidade disponibilidade) {
        // Impedir disponibilidade duplicada na mesma hora e vaga
        boolean existe = repository.existsByDataAndHoraInicioAndVaga(
                disponibilidade.getData(),
                disponibilidade.getHoraInicio(),
                disponibilidade.getVaga()
        );
        if (existe) {
            return null;
        }
        return repository.save(disponibilidade);
    }

    public List<Disponibilidade> listar() {
        return repository.findAll();
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}