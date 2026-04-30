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
public class Comprovativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComprovativo;

    private Long idPagamento;
    private LocalDate dataEmissao;

    @OneToOne
    @JoinColumn(name = "idPagamento")
    private Pagamento pagamento;
}
