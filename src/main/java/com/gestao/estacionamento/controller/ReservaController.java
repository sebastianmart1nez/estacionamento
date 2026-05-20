package com.gestao.estacionamento.controller;

import com.gestao.estacionamento.model.Perfil;
import com.gestao.estacionamento.model.Utilizador;
import com.gestao.estacionamento.service.ReservaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(HttpSession session, Model model) {
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if (user == null) return "redirect:/login";

        if (user.getPerfil() == Perfil.CLIENTE) {
            model.addAttribute("vagasDisponiveis", service.getVagasDisponiveis());
            model.addAttribute("reservas", service.listarPorCliente(user.getEmail()));
        } else {
            model.addAttribute("reservas", service.listarTodas());
        }
        return "reservas";
    }

    @PostMapping
    public String reservar(@RequestParam String numeroVaga, HttpSession session) {
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if (user == null) return "redirect:/login";
        if (user.getPerfil() != Perfil.CLIENTE) return "redirect:/";

        service.reservar(user.getEmail(), numeroVaga);
        return "redirect:/reservas";
    }

    @PostMapping("/cancelar")
    public String cancelar(@RequestParam Long id, HttpSession session) {
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if (user == null) return "redirect:/login";

        service.cancelar(id);
        return "redirect:/reservas";
    }
}