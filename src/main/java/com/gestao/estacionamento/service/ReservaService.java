package com.gestao.estacionamento.service;

import com.gestao.estacionamento.model.Reserva;
import com.gestao.estacionamento.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {
    private final ReservaRepository repository;

    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    public List<Integer> getVagasDisponiveis(){
        List<Reserva> ativas = repository.findByEstado("ATIVA");

        List<String> ocupadas = new ArrayList<>();
        for (Reserva r : ativas) {
            ocupadas.add(r.getNumeroVaga());
        }

        List<Integer> disponiveis = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            String vaga = String.valueOf(i);
            if (ocupadas.contains(vaga)) {
                disponiveis.add(i);
            }
        }
        return disponiveis;
    }

    public Reserva reservar(String email, String numeroVaga){
        Reserva existente = repository.findByNumeroVagaAndEstado(numeroVaga, "ATIVA");
        if (existente != null) {
            return null;
        }

        Reserva reserva = new Reserva();
        reserva.setEmail(email);
        reserva.setNumeroVaga(numeroVaga);
        reserva.setDataReserva(LocalDateTime.now());
        reserva.setEstado("ATIVA");
        return repository.save(reserva);
    }

    public void cancelar(Long id){
        Reserva reserva = repository.findById(id).orElse(null);
        if (reserva != null) {
            reserva.setEstado("CANCELADA");
            repository.save(reserva);
        }
    }

    public List<Reserva> listarPorCliente(String email){
        return repository.findByEmail(email);
    }
}
