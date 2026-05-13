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

    // guardar utilizador
    public Utilizador guardar(Utilizador utilizador) {
        return repository.save(utilizador);
    }

    // listar utilizadores
    public List<Utilizador> listarTodos() {
        return repository.findAll();
    }

    // procurar username
    public Utilizador procurarPorUsername(String username) {
        return repository.findbyUsername(username);
    }

    // validar login
    public boolean validarLogin(String email, String password) {

        Utilizador utilizador = repository.findByEmail(email,password);

        if (utilizador == null) {
            return false;
        }

        return utilizador.getPassword().equals(password);
    }
}