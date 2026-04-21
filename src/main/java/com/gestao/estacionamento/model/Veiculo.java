package com.gestao.estacionamento.model;

public class Veiculo {

    private String matricula;
    private String horaEntrada;

    public Veiculo(String matricula, String horaEntrada) {
        this.matricula = matricula;
        this.horaEntrada = horaEntrada;
    }

    public String getMatricula() {
        return matricula;
    }


    public String getHoraEntrada() { return horaEntrada; }
}