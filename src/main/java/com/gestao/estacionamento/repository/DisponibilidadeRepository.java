package com.gestao.estacionamento.repository;

import com.gestao.estacionamento.model.Disponibilidade;
import com.gestao.estacionamento.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, Long> {
    boolean existsByDataAndHoraInicioAndVaga(LocalDate data, LocalTime horaInicio, Vaga vaga);
}