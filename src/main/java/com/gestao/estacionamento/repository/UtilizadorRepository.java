package com.gestao.estacionamento.repository;

import com.gestao.estacionamento.model.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UtilizadorRepository extends JpaRepository<Utilizador, Long> {
    Optional<Utilizador> findByEmailAndSenha(String email, String senha);
}
