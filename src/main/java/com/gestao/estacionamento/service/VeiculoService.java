package com.gestao.estacionamento.service;

import com.gestao.estacionamento.model.Veiculo;
import com.gestao.estacionamento.repository.VeiculoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }

    public void guardar(Veiculo veiculo) {
        repository.save(veiculo);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public int getVagasOcupadas() {
        return repository.findAll().size();
    }

    public int getVagasDisponiveis() {
        return Math.max(0, 50 - getVagasOcupadas());
    }

    public int getTotalHoje() {
        return repository.findAll().size();
    }

    public double calcularReceita() {
        return repository.findAll().size() * 1.5;
    }
}
