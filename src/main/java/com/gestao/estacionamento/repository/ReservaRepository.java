package com.gestao.estacionamento.repository;

import com.gestao.estacionamento.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByEmail(String email);
    List<Reserva> findByEstado(String estado);
    Reserva findByNumeroVagaAndEstado(String numeroVaga, String estado);
}
