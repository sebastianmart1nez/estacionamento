package com.gestao.estacionamento.repository;

import com.gestao.estacionamento.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
