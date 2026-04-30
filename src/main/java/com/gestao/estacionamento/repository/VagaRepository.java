package com.gestao.estacionamento.repository;

import com.gestao.estacionamento.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
}
