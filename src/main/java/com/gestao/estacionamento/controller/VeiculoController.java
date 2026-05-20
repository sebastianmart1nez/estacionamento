package com.gestao.estacionamento.controller;

import com.gestao.estacionamento.model.Utilizador;
import com.gestao.estacionamento.model.Veiculo;
import com.gestao.estacionamento.service.VeiculoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model, HttpSession session) {
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if (user == null) return "redirect:/login";

        model.addAttribute("lista", service.listarTodos());
        model.addAttribute("vagasDisponiveis", service.getVagasDisponiveis());
        model.addAttribute("vagasOcupadas", service.getVagasOcupadas());
        model.addAttribute("veiculosHoje", service.getTotalHoje());
        model.addAttribute("receitaHoje", String.format("%.2f", service.calcularReceita()));
        return "veiculo";
    }

    @PostMapping
    public String adicionar(@RequestParam String matricula,
                            @RequestParam String horaEntrada,
                            HttpSession session) {
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if (user == null) return "redirect:/login";

        Veiculo veiculo = new Veiculo(null, matricula, horaEntrada, null);
        service.guardar(veiculo);
        return "redirect:/veiculos";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, HttpSession session) {
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if (user == null) return "redirect:/login";

        service.eliminar(id);
        return "redirect:/veiculos";
    }
}
