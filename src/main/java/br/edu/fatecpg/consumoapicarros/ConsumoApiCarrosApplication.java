package br.edu.fatecpg.consumoapicarros;

import br.edu.fatecpg.consumoapicarros.model.Carro;
import br.edu.fatecpg.consumoapicarros.service.ConsomeApiFipe;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ConsumoApiCarrosApplication implements CommandLineRunner {

	public static void main(String[] args) {
        SpringApplication.run(ConsumoApiCarrosApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Gson gson = new Gson();

        System.out.println("Seja bem vindo usuário!\n");

        String buscaMarcas = ConsomeApiFipe.obterDado("https://parallelum.com.br/fipe/api/v1/carros/marcas");
        System.out.println(buscaMarcas);
        System.out.println("\nDigite o código da marca desejada: ");
        String codMarca = scan.nextLine();

        String  buscaModelos = ConsomeApiFipe.obterDado("https://fipe.parallelum.com.br/api/v1/carros/marcas/" + codMarca + "/modelos/");
        System.out.println("\n" + buscaModelos);
        System.out.println("\nDigite o código do modelo desejado: ");
        String codModelo = scan.nextLine();

        String buscaAnos = ConsomeApiFipe.obterDado("https://fipe.parallelum.com.br/api/v1/carros/marcas/" + codMarca + "/modelos/" + codModelo + "/anos/");
        System.out.println("\n" + buscaAnos);
        System.out.println("\nDigite o ano desejado: ");
        String codAno = scan.nextLine();

        String carroEncontrado = ConsomeApiFipe.obterDado("https://fipe.parallelum.com.br/api/v1/carros/marcas/" + codMarca + "/modelos/" + codModelo + "/anos/"+ codAno);
        Carro carro = gson.fromJson(carroEncontrado, Carro.class);
        System.out.println("\n" + carro);
    }
}
