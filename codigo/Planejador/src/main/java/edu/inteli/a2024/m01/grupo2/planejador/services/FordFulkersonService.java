package edu.inteli.a2024.m01.grupo2.planejador.services;

import edu.inteli.a2024.m01.grupo2.planejador.models.Digrafo;
import edu.inteli.a2024.m01.grupo2.planejador.models.FordFulkerson;
import org.springframework.stereotype.Service;

/**
 * Serviço para o algoritmo de Ford-Fulkerson.

 */
@Service
public class FordFulkersonService {

    /**
     * Calcula o fluxo máximo de um digrafo
     * @param digrafo Digrafo
     * @param source ID do Nó Fonte
     * @param sink ID do Nó Sumidouro
     * @return Objeto do tipo ResultadoFordFulkerson
     */
    public FordFulkerson.ResultadoFordFulkerson calculateMaxFlow(Digrafo digrafo, int source, int sink) {
        FordFulkerson fordFulkerson = new FordFulkerson(digrafo);
        return fordFulkerson.fordFulkerson(source, sink);
    }
}
