package com.gestao.estacionamento;

import com.gestao.estacionamento.model.*;
import com.gestao.estacionamento.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EstacionamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionamentoApplication.class, args);
	}

	@Bean
	public CommandLineRunner seedData(
			UtilizadorRepository utilizadorRepo,
			VagaRepository vagaRepo) {
		return args -> {
			if (utilizadorRepo.count() == 0) {
				utilizadorRepo.save(new Utilizador(null, "Administrador", "admin@gmail.com", "1234", Perfil.ADMIN));
				utilizadorRepo.save(new Utilizador(null, "Funcionário Silva", "func@gmail.com", "1234", Perfil.FUNCIONARIO));
				utilizadorRepo.save(new Utilizador(null, "Cliente João", "cliente@gmail.com", "1234", Perfil.CLIENTE));
			}
			if (vagaRepo.count() == 0) {
				String[] numeros = {"A1","A2","A3","A4","A5","B1","B2","B3","B4","B5",
						"C1","C2","C3","C4","C5","D1","D2","D3","D4","D5"};
				for (String n : numeros) {
					vagaRepo.save(new Vaga(null, n, true));
				}
			}
		};
	}
}