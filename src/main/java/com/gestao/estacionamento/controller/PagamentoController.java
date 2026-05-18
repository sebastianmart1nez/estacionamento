package com.gestao.estacionamento.controller;

import com.gestao.estacionamento.model.Pagamento;
import com.gestao.estacionamento.model.Utilizador;
import com.gestao.estacionamento.service.PagamentoService;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class PagamentoController {

    private final PagamentoService service;

    public PagamentoController(PagamentoService service) {
        this.service = service;
    }

    @GetMapping("/pagamentos")
    public String listar(Model model, HttpSession session) {
            Utilizador utilizador = (Utilizador) session.getAttribute("utilizadorLogado");

        model.addAttribute(
                "lista",
                service.listarTodos()
        );

        model.addAttribute(
                "totalPagamentos",
                service.getTotalPagamentos()
        );

        model.addAttribute(
                "receitaHoje",
                String.format("%.2f",
                        service.getReceitaHoje())
        );

        model.addAttribute(
                "pagamentosPendentes",
                0
        );

        model.addAttribute(
                "valorMedio",
                String.format("%.2f",
                        service.getValorMedio())
        );

        return "pagamento";
    }

    @PostMapping("/pagamentos")
    public String registarPagamento(

            @RequestParam String matricula,

            @RequestParam double valor,

            @RequestParam String metodoPagamento
    ) {

        Pagamento pagamento = new Pagamento();

        pagamento.setMatricula(matricula);

        pagamento.setValor(valor);

        pagamento.setDataPagamento(
                LocalDate.now()
        );

        pagamento.setMetodoPagamento(
                metodoPagamento
        );

        service.guardar(pagamento);

        return "redirect:/pagamentos";
    }
}