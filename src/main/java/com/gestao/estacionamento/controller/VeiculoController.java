package com.gestao.estacionamento.controller;

import com.gestao.estacionamento.service.VeiculoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador responsável pelas rotas da aplicação.
 */
@Controller
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @GetMapping("/veiculos")
    public String listar(Model model) {

        model.addAttribute("lista", service.listarTodos());
        model.addAttribute("vagasDisponiveis", service.getVagasDisponiveis());
        model.addAttribute("vagasOcupadas", service.getVagasOcupadas());
        model.addAttribute("veiculosHoje", service.getTotalHoje());
        model.addAttribute("receitaHoje", service.calcularReceita());

        return "veiculo";
    }

    @PostMapping("/veiculos")
    public String adicionar(@RequestParam String matricula,
                            @RequestParam String horaEntrada) {

        service.adicionar(matricula, horaEntrada);
        return "redirect:/veiculos";
    }
}