package com.gestao.estacionamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entidade que representa um veículo no sistema.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricula;

    /**
     * Guardado como String por simplicidade.
     * Em contexto real, deve ser LocalDateTime.
     */
    private String horaEntrada;

   @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
}