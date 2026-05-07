package com.gestao.estacionamento.service;

import com.gestao.estacionamento.model.Pagamento;
import com.gestao.estacionamento.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {
    private final PagamentoRepository repository;

    public PagamentoService(PagamentoRepository repository) {
        this.repository = repository;
    }

    public List<Pagamento> listarTodos() {
        return repository.findAll();
    }

    public void guardar(Pagamento pagamento) {
        this.repository.save(pagamento);
    }

    public int getTotalPagamentos(){
        return repository.findAll().size();
    }

    public double getReceitaHoje(){
        return repository.findAll().stream()
                .mapToDouble(Pagamento::getValor).sum();
    }

    public double getValorMedio(){
        List<Pagamento> todos = repository.findAll();
        if(todos.isEmpty()) return 0.0;
        return todos.stream().mapToDouble(Pagamento::getValor).average().orElse(0.0);
    }
}
