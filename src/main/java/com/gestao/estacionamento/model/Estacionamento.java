package com.gestao.estacionamento.model;

import jakarta.persistence.*;
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

@OneToOne
    private Pagamento pagamento;

@OneToOne
    private Funcionario funcionario;

}
