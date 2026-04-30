package com.gestao.estacionamento.repository;

import com.gestao.estacionamento.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
