package com.gestao.estacionamento.controller;

import com.gestao.estacionamento.model.Utilizador;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String inicio(HttpSession session) {
    Utilizador user = (Utilizador) session.getAttribute("utilizadorLogado");
    if (user == null){
        return "redirect:/login";
    }
        return "index";
    }
}