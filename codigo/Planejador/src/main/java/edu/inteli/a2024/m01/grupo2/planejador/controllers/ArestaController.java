package edu.inteli.a2024.m01.grupo2.planejador.controllers;

import edu.inteli.a2024.m01.grupo2.planejador.models.Aresta;
import edu.inteli.a2024.m01.grupo2.planejador.repositories.ArestaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador REST para operações relacionadas a arestas no planejador.
 * Permite a recuperação de informações sobre as arestas, incluindo listagem de
 * todas as arestas disponíveis.
 */
@RestController
public class ArestaController {
    private final ArestaRepository arestaRepository;

    /**
     * Construtor que injeta a dependência do repositório de arestas para o
     * controlador.
     *
     * @param arestaRepository O repositório para operações de banco de dados
     *                         relacionadas a arestas.
     */
    public ArestaController(ArestaRepository arestaRepository) {
        this.arestaRepository = arestaRepository;
    }

    /**
     * Endpoint para recuperar todas as arestas disponíveis.
     * Habilita a origem cruzada (CORS) para permitir solicitações de diferentes
     * origens.
     *
     * @return Um iterável contendo todas as arestas.
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
            RequestMethod.PUT, RequestMethod.DELETE })
    @GetMapping("/arestas")
    public Iterable<Aresta> findAll() {
        return this.arestaRepository.findAll();
    }
}
