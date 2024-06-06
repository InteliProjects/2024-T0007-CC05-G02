package edu.inteli.a2024.m01.grupo2.planejador.services;

import edu.inteli.a2024.m01.grupo2.planejador.models.Aresta;
import edu.inteli.a2024.m01.grupo2.planejador.models.No;
import edu.inteli.a2024.m01.grupo2.planejador.models.Digrafo;
import edu.inteli.a2024.m01.grupo2.planejador.repositories.NoRepository;
import edu.inteli.a2024.m01.grupo2.planejador.repositories.ArestaRepository;
import edu.inteli.a2024.m01.grupo2.planejador.services.PopularGrafoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Serviço para popular o grafo com os dados do banco de dados.

 */
@Service
public class PopularGrafoService{

    private final NoRepository noRepository;
    private final ArestaRepository arestaRepository;

    @Autowired
    public PopularGrafoService(NoRepository noRepository, ArestaRepository arestaRepository) {
        this.noRepository = noRepository;
        this.arestaRepository = arestaRepository;
    }

    /**
     * Constrói um grafo a partir dos nós e arestas do banco de dados.
     * @return Dirafo construído.
     */
    public Digrafo construirGrafo() {
        int nos = (int) noRepository.count();
        Iterable<Aresta> arestas = arestaRepository.findAll();

        Digrafo grafo = new Digrafo(nos);

        for (Aresta aresta : arestas) {
            grafo.adicionarAresta((int) aresta.idEloCadeiaProducaoOrigem, (int) aresta.idEloCadeiaProducaoDestino, aresta.pesoMedio, aresta.codigoSubModal, aresta.codigoTipoModal, aresta.descricao);
        }

        return grafo;
    }
}

