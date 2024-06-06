package edu.inteli.a2024.m01.grupo2.planejador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Classe principal que inicia a aplicação Spring Boot.
 * Anotada com @SpringBootApplication, indica que é o ponto de entrada principal
 * para a execução
 * da aplicação, configurando automaticamente a configuração baseada em
 * convenção sobre configuração,
 * component scan, e configuração de beans.
 */
@SpringBootApplication
public class Main {
	/**
	 * Método principal que inicia a aplicação.
	 * Utiliza SpringApplication.run para iniciar o contexto da aplicação Spring,
	 * carregando todas as configurações
	 * e beans necessários para o funcionamento da aplicação.
	 * 
	 * @param args Argumentos de linha de comando passados para a aplicação.
	 */
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Main.class, args);
	}

}
