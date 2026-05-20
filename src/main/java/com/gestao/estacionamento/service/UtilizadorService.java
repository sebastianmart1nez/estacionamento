package com.gestao.estacionamento.service;

import com.gestao.estacionamento.model.Utilizador;
import com.gestao.estacionamento.repository.UtilizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UtilizadorService {

    @Autowired
    private UtilizadorRepository repository;

    public Utilizador salvar(Utilizador utilizador) {
        return repository.save(utilizador);
    }

    public List<Utilizador> listar() {
        return repository.findAll();
    }

    public Utilizador login(String email, String senha) {
        if (email == null || email.isBlank() || senha == null || senha.isBlank()) {
            return null;
        }
        return repository.findByEmailAndSenha(email, senha).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}