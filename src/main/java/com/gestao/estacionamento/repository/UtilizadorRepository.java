package com.gestao.estacionamento.repository;

import com.gestao.estacionamento.model.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilizadorRepository extends JpaRepository<Utilizador, Long> {

    Utilizador findByEmail(String email, String password);


}
