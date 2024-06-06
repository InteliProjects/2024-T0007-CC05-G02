package edu.inteli.a2024.m01.grupo2.planejador.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para a página inicial da API.
 * Este controlador fornece um ponto de entrada simples para verificar se a API
 * está operacional.
 */
@RestController
public class IndexController {
    /**
     * Endpoint para a página inicial da API.
     * Retorna uma mensagem de boas-vindas indicando que a API está operacional. Não
     * tem funcionalidade diretamente ligada ao problema da Vale.
     *
     * @return Uma string de mensagem de boas-vindas.
     */
    @GetMapping("/")
    public String index() {
        return "Bem-vindo à API do Grupo 2!";
    }

}