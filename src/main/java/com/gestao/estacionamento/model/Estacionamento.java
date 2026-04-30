package com.gestao.estacionamento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstacionamento;

    private String matricula;
    private Long idVaga;
    private Long idFuncionario;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private LocalTime tempoPermanencia;



}
