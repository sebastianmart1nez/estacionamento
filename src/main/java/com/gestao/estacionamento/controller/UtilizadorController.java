package com.gestao.estacionamento.controller;

import com.gestao.estacionamento.service.UtilizadorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UtilizadorController {

    private final UtilizadorService utilizadorService;

    public UtilizadorController(UtilizadorService utilizadorService) {
        this.utilizadorService = utilizadorService;
    }

    @GetMapping("/login")
    public String mostrarLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String fazerLogin(@RequestParam String email,
                             @RequestParam String senha,
                             HttpSession session,
                             Model model){
        Utilizador u = utilizadorService.autenticar(email,senha);
        if (u != null){
            session.setAttribute("utilizadorLogado", u);
            return "redirect:/";
        }

        model.addAttribute("ERRO", "Email ou senha invalidos");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/utilizadores")
    public String listarUtilizadores (Model model){
        model.addAttribute("lista", utilizadorService.listarTodos());
        return "utilizadores";
    }

    @PostMapping("/utilizadores")
    public String adicionarUtilizador(Utilizador utilizador){
        utilizadorService.guardar(utilizador);
        return "redirect:/utilizadores";
    }
}
