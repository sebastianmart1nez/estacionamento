package com.gestao.estacionamento.repository;

import com.gestao.estacionamento.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByEmail(String email);
    List<Reserva> findByEstado(String estado);
    Reserva findByNumeroVagaAndEstado(String numeroVaga, String estado);
}
