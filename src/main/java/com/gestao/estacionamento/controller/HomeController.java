package com.gestao.estacionamento.controller;

import com.gestao.estacionamento.model.Utilizador;
import com.gestao.estacionamento.repository.VeiculoRepository;
import com.gestao.estacionamento.repository.ReservaRepository;
import com.gestao.estacionamento.repository.PagamentoRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("totalVeiculos", veiculoRepository.count());
        model.addAttribute("totalReservas", reservaRepository.count());
        model.addAttribute("totalPagamentos", pagamentoRepository.count());
        return "index";
    }
}