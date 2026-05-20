package com.gestao.estacionamento.controller;

import com.gestao.estacionamento.model.Utilizador;
import com.gestao.estacionamento.service.UtilizadorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UtilizadorService utilizadorService;

    @GetMapping("/login")
    public String loginPage(HttpSession session) {
        if (session.getAttribute("utilizadorLogado") != null) {
            return "redirect:/";
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String senha,
            HttpSession session,
            Model model) {

        Utilizador utilizador = utilizadorService.login(email, senha);

        if (utilizador != null) {
            session.setAttribute("utilizadorLogado", utilizador);
            return "redirect:/";
        }

        model.addAttribute("erro", "Email ou senha inválidos. Tente novamente.");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}