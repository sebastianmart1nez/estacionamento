package com.gestao.estacionamento.controller;

import com.gestao.estacionamento.model.Disponibilidade;
import com.gestao.estacionamento.model.Perfil;
import com.gestao.estacionamento.model.Utilizador;
import com.gestao.estacionamento.repository.VagaRepository;
import com.gestao.estacionamento.service.DisponibilidadeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/disponibilidades")
public class DisponibilidadeController {

    @Autowired
    private DisponibilidadeService service;

    @Autowired
    private VagaRepository vagaRepository;

    @GetMapping
    public String listar(Model model, HttpSession session) {
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if (user == null) return "redirect:/login";
        if (user.getPerfil() == Perfil.CLIENTE) return "redirect:/";

        model.addAttribute("disponibilidades", service.listar());
        model.addAttribute("vagas", vagaRepository.findAll());
        model.addAttribute("disponibilidade", new Disponibilidade());
        return "disponibilidades";
    }

    @PostMapping
    public String salvar(@ModelAttribute Disponibilidade disponibilidade,
                         HttpSession session, Model model) {
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if (user == null) return "redirect:/login";
        if (user.getPerfil() == Perfil.CLIENTE) return "redirect:/";

        Disponibilidade resultado = service.salvar(disponibilidade);
        if (resultado == null) {
            model.addAttribute("erro", "Já existe disponibilidade registada para essa vaga nessa hora.");
            model.addAttribute("disponibilidades", service.listar());
            model.addAttribute("vagas", vagaRepository.findAll());
            model.addAttribute("disponibilidade", disponibilidade);
            return "disponibilidades";
        }
        return "redirect:/disponibilidades";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, HttpSession session) {
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if (user == null) return "redirect:/login";
        if (user.getPerfil() == Perfil.CLIENTE) return "redirect:/";

        service.eliminar(id);
        return "redirect:/disponibilidades";
    }
}
