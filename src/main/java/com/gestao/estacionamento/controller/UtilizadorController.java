package com.gestao.estacionamento.controller;

import com.gestao.estacionamento.model.Utilizador;
import com.gestao.estacionamento.service.UtilizadorService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UtilizadorController {

    @Autowired
    private UtilizadorService service;

    // abrir página utilizadores
    @GetMapping("/utilizadores")
    public String abrirPaginaUtilizadores(Model model) {

        model.addAttribute("utilizador", new Utilizador());

        model.addAttribute("listaUtilizadores",
                service.listarTodos());

        return "utilizadores";
    }

    // guardar utilizador
    @PostMapping("/guardarUtilizador")
    public String guardarUtilizador(Utilizador utilizador) {

        service.guardar(utilizador);

        return "redirect:/utilizadores";
    }

    // abrir login
    @GetMapping("/login")
    public String abrirLogin() {
        return "login";
    }

    // validar login
    @PostMapping("/login")
    public String fazerLogin(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session,
            Model model) {
        Utilizador utilizador=service.validarLogin(email,password);


        if (utilizador != null) {
            session.setAttribute("utilizadorLogado",utilizador);
            return "redirect:/home";
        }



            model.addAttribute("erro",
                    "Username ou password incorretos!");


        return "login";
    }
}