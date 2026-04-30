package com.gestao.estacionamento.repository;

import com.gestao.estacionamento.model.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long> {
}
