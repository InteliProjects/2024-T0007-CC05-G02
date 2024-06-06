package edu.inteli.a2024.m01.grupo2.planejador.controllers;

import edu.inteli.a2024.m01.grupo2.planejador.models.No;
import edu.inteli.a2024.m01.grupo2.planejador.repositories.NoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controlador REST para operações relacionadas a nós (vertices) no planejador.
 * Permite a recuperação de informações sobre os nós, incluindo listagem e
 * contagem total.
 */
@RestController
public class NoController {
    private final NoRepository noRepository;

    /**
     * Construtor que injeta a dependência do repositório de nós para o controlador.
     *
     * @param noRepository O repositório para operações de banco de dados
     *                     relacionadas a nós.
     */
    public NoController(NoRepository noRepository) {
        this.noRepository = noRepository;
    }

    /**
     * Endpoint para recuperar todos os nós disponíveis.
     * Habilita a origem cruzada (CORS) para permitir solicitações de diferentes
     * origens.
     *
     * @return Um iterável contendo todos os nós.
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
            RequestMethod.PUT, RequestMethod.DELETE })
    @GetMapping("/nos")
    public Iterable<No> findAll() {
        return this.noRepository.findAll();
    }

    /**
     * Endpoint para contar o número total de nós.
     * Habilita a origem cruzada (CORS) para permitir solicitações de diferentes
     * origens.
     *
     * @return O número total de nós.
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
            RequestMethod.PUT, RequestMethod.DELETE })
    @GetMapping("/nos/count")
    public long countNos() {
        return noRepository.count();
    }

}
