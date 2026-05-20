package com.gestao.estacionamento.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idPagamento;

   private String matricula;

   private Double valor;

   private LocalDate dataPagamento;

   private String metodoPagamento;
}

