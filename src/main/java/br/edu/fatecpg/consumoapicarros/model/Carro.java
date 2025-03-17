package br.edu.fatecpg.consumoapicarros.model;

public class Carro {
    public String Modelo;
    public String Marca;
    public String AnoModelo;
    public String Valor;

    @Override
    public String toString() {
        return "Carro{" +
            "Modelo='" + Modelo + '\'' +
            ", Marca='" + Marca + '\'' +
            ", Ano='" + AnoModelo + '\'' +
            ", Valor='" + Valor + '\'' +
            '}';
    }
}
