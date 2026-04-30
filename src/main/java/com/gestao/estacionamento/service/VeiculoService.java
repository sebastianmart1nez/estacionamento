package com.gestao.estacionamento.service;

import com.gestao.estacionamento.model.Veiculo;
import com.gestao.estacionamento.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Camada de lógica de negócio.
 */
@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }

    public void adicionar(String matricula, String horaEntrada) {
        Veiculo v = new Veiculo();
        v.setMatricula(matricula);
        v.setHoraEntrada(horaEntrada);
        repository.save(v);
    }

    public int getVagasOcupadas() {
        return repository.findAll().size();
    }

    public int getVagasDisponiveis() {
        return 50 - getVagasOcupadas();
    }

    public int getTotalHoje() {
        return repository.findAll().size();
    }

    public double calcularReceita() {
        return repository.findAll().size() * 1.5;
    }
}
