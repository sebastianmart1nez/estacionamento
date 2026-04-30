package com.gestao.estacionamento.model;

import jakarta.persistence.*;
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


   @OneToOne
   @JoinColumn(name = "idEstacionamento")
   private Estacionamento estacionamento;

   @OneToOne(mappedBy = "pagamento")
   private Comprovativo comprovativo;
}

