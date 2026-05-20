package com.gestao.estacionamento.controller;

import com.gestao.estacionamento.model.Perfil;
import com.gestao.estacionamento.model.Utilizador;
import com.gestao.estacionamento.service.UtilizadorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/utilizadores")
public class UtilizadorController {

    @Autowired
    private UtilizadorService service;

    @GetMapping
    public String listar(HttpSession session, Model model) {
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if (user == null) return "redirect:/login";
        if (user.getPerfil() != Perfil.ADMIN) return "redirect:/";

        model.addAttribute("utilizador", new Utilizador());
        model.addAttribute("listaUtilizadores", service.listar());
        model.addAttribute("perfis", Perfil.values());
        return "utilizadores";
    }

    @PostMapping
    public String salvar(@ModelAttribute Utilizador utilizador, HttpSession session) {
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if (user == null) return "redirect:/login";
        if (user.getPerfil() != Perfil.ADMIN) return "redirect:/";

        service.salvar(utilizador);
        return "redirect:/utilizadores";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, HttpSession session) {
        Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
        if (user == null) return "redirect:/login";
        if (user.getPerfil() != Perfil.ADMIN) return "redirect:/";

        service.eliminar(id);
        return "redirect:/utilizadores";
    }
}