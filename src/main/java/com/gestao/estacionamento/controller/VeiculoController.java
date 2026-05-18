package com.gestao.estacionamento.controller;

import com.gestao.estacionamento.model.Utilizador;
import com.gestao.estacionamento.model.Veiculo;
import com.gestao.estacionamento.service.VeiculoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @GetMapping("/veiculos")
    public String listar(Model model, HttpSession session) {
        Utilizador utilizador = (Utilizador) session.getAttribute("utilizadorLogado");

        model.addAttribute("lista", service.listarTodos());

        model.addAttribute(
                "vagasDisponiveis",
                service.getVagasDisponiveis()
        );

        model.addAttribute(
                "vagasOcupadas",
                service.getVagasOcupadas()
        );

        model.addAttribute(
                "veiculosHoje",
                service.getTotalHoje()
        );

        model.addAttribute(
                "receitaHoje",
                service.calcularReceita()
        );

        return "veiculo";
    }

    @PostMapping("/veiculos")
    public String adicionarVeiculo(
            @RequestParam String matricula,
            @RequestParam String horaEntrada
    ) {

        Veiculo veiculo = new Veiculo(
                null,
                matricula,
                horaEntrada,
                null
        );

        service.guardar(veiculo);

        return "redirect:/veiculos";
    }
}