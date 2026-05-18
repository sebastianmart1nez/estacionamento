package com.gestao.estacionamento.controller;

import com.gestao.estacionamento.model.Utilizador;
import com.gestao.estacionamento.service.ReservaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservaController {
    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @GetMapping("/reservas")
    public String abrirReservas(HttpSession session, Model model){
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if(user == null || !"CLIENTE".equals(user.getPerfil())){
            return "redirect:/login";
        }

        model.addAttribute("VagasDisponiveis", service.getVagasDisponiveis());
        model.addAttribute("reservas", service.listarPorCliente(user.getEmail()));
        return "reservas";
    }

    @PostMapping("/reservas")
    public String reservarVaga(@RequestParam String numeroVaga, HttpSession session){
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if(user == null || !"CLIENTE".equals(user.getPerfil())){
            return "redirect:/login";
        }

        service.reservar(user.getEmail(), numeroVaga);
        return "redirect:/reservas";
    }

    @PostMapping("/reservas/cancelar")
    public String cancelarReserva(@RequestParam Long id, HttpSession session){
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if(user == null || !"CLIENTE".equals(user.getPerfil())){
            return "redirect:/login";
        }

        service.cancelar(id);
        return "redirect:/reservas";
    }
}
