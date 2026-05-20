package com.gestao.estacionamento.controller;

import com.gestao.estacionamento.model.Pagamento;
import com.gestao.estacionamento.model.Utilizador;
import com.gestao.estacionamento.service.PagamentoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Controller
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService service;

    public PagamentoController(PagamentoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model, HttpSession session) {
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if (user == null) return "redirect:/login";

        model.addAttribute("lista", service.listarTodos());
        model.addAttribute("totalPagamentos", service.getTotalPagamentos());
        model.addAttribute("receitaHoje", String.format("%.2f", service.getReceitaHoje()));
        model.addAttribute("valorMedio", String.format("%.2f", service.getValorMedio()));
        return "pagamento";
    }

    @PostMapping
    public String registar(@RequestParam String matricula,
                           @RequestParam double valor,
                           @RequestParam String metodoPagamento,
                           HttpSession session) {
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if (user == null) return "redirect:/login";

        Pagamento pagamento = new Pagamento(null, matricula, valor, LocalDate.now(), metodoPagamento);
        service.guardar(pagamento);
        return "redirect:/pagamentos";
    }
}