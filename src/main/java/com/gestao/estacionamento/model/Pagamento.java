package com.gestao.estacionamento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idPagamento;

   private Long idEstacionamento;
   private double valor;
   private LocalDate dataPagamento;
   private String metodoPagamento;
}
