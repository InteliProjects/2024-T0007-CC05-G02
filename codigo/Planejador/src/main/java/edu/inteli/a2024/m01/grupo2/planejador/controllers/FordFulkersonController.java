package edu.inteli.a2024.m01.grupo2.planejador.controllers;

import edu.inteli.a2024.m01.grupo2.planejador.models.Digrafo;
import edu.inteli.a2024.m01.grupo2.planejador.repositories.ArestaRepository;
import edu.inteli.a2024.m01.grupo2.planejador.services.FordFulkersonService;
import edu.inteli.a2024.m01.grupo2.planejador.models.FordFulkerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.inteli.a2024.m01.grupo2.planejador.repositories.NoRepository;
import edu.inteli.a2024.m01.grupo2.planejador.models.Aresta;
import edu.inteli.a2024.m01.grupo2.planejador.models.No;

/**
 * Controlador para o algoritmo de Ford-Fulkerson.
 */
@RestController
public class FordFulkersonController {

    private final FordFulkersonService fordFulkersonService;
    private final ArestaRepository arestaRepository;
    private final NoRepository noRepository;
    private Digrafo digrafo;

    @Autowired
    public FordFulkersonController(FordFulkersonService fordFulkersonService, ArestaRepository arestaRepository, NoRepository noRepository) {
        this.fordFulkersonService = fordFulkersonService;
        this.arestaRepository = arestaRepository;
        this.noRepository = noRepository;

        construirGrafo();
    }

    /**
     * Constrói o grafo a partir dos dados do banco de dados.
     */
    private void construirGrafo() {
        int nos = (int) this.noRepository.count();
        Iterable<Aresta> arestas = this.arestaRepository.findAll();

        Digrafo grafo = new Digrafo(nos);

        for (Aresta aresta : arestas) {
            grafo.adicionarAresta((int) aresta.idEloCadeiaProducaoOrigem, (int) aresta.idEloCadeiaProducaoDestino, aresta.pesoMedio, aresta.codigoSubModal, aresta.codigoTipoModal, aresta.descricao);
        }

        this.digrafo = grafo;
    }

    /**
     * Calcula o fluxo máximo do grafo.
     * @return O resultado do algoritmo de Ford-Fulkerson.
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    @GetMapping("/FordFulkerson")
    public FordFulkerson.ResultadoFordFulkerson  calculateMaxFlow() {
        int nos = (int) this.noRepository.count(); 
        int source = 0; 
        int sink = digrafo.getQuantidadeNos() - 1; 
        
        return fordFulkersonService.calculateMaxFlow(this.digrafo, source, sink);
    }
}
