package com.gestao.estacionamento.controler;

import org.springframework.ui.Model;
import com.gestao.estacionamento.model.Veiculo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VeiculoControler {

    private List<Veiculo> veiculos = new ArrayList<>();

@GetMapping("/veiculos")
    public String listarVeiculos(Model model) {
        model.addAttribute("mensagem", "Lista de Veículos");
        model.addAttribute("lista", veiculos);
        return "veiculo";
    }
@PostMapping("/veiculos")
    public String adicionarVeiculo(@RequestParam String matricula, @RequestParam String horaEntrada) {
        veiculos.add(new Veiculo(matricula, horaEntrada));
        return "redirect:/veiculos";
    }
}
