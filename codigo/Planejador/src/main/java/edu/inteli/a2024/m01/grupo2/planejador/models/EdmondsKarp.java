package edu.inteli.a2024.m01.grupo2.planejador.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import edu.inteli.a2024.m01.grupo2.planejador.dtos.ArestaDTO;

/**
 * Implementação do algoritmo de Edmonds-Karp para encontrar o fluxo máximo em
 * um digrafo.
 * Esta classe utiliza o conceito de busca em largura para encontrar caminhos de
 * aumento e calcular o fluxo máximo.
 */

public class EdmondsKarp {
    private Digrafo grafo;
    private int[] pai;
    private int noOrigem;
    private int noDestino;

    /**
     * Construtor da classe EdmondsKarp.
     * 
     * @param grafo     O digrafo sobre o qual o algoritmo é aplicado.
     * @param noOrigem  O nó de origem no digrafo.
     * @param noDestino O nó de destino no digrafo.
     */

    public EdmondsKarp(Digrafo grafo, int noOrigem, int noDestino) {
        this.grafo = grafo;
        this.noOrigem = noOrigem;
        this.noDestino = noDestino;
        this.pai = new int[grafo.getQuantidadeNos()];
    }

    /**
     * Realiza uma busca em largura para encontrar um caminho de aumento do nó de
     * origem ao nó de destino.
     * 
     * @return true se um caminho de aumento foi encontrado, false caso contrário.
     */

    private boolean buscaLargura() {
        Arrays.fill(pai, -1);
        pai[noOrigem] = noOrigem;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(noOrigem);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (Aresta adj : grafo.getListaAdjacencia().get(u)) {
                int v = adj.idEloCadeiaProducaoDestino;
                if (pai[v] == -1 && adj.getFluxoUtilizado() < adj.pesoMedio) {
                    pai[v] = u;
                    queue.offer(v);
                    if (v == noDestino) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Executa o algoritmo de Edmonds-Karp para calcular o fluxo máximo do nó de
     * origem ao nó de destino.
     * 
     * @return Um objeto ResultadoEdmondsKarp contendo o fluxo máximo e detalhes dos
     *         fluxos nas arestas.
     */

    public ResultadoEdmondsKarp edmondsKarp() {
        double fluxoMaximo = 0;
        Map<Aresta, Double> fluxoArestas = new HashMap<>();
        List<ArestaDTO> arestasDTO = new ArrayList<>();

        while (buscaLargura()) {
            double fluxoCaminho = Double.MAX_VALUE;

            for (int v = noDestino; v != noOrigem; v = pai[v]) {
                int u = pai[v];
                for (Aresta adj : grafo.getListaAdjacencia().get(u)) {
                    if (adj.idEloCadeiaProducaoDestino == v) {
                        fluxoCaminho = Math.min(fluxoCaminho, adj.pesoMedio - adj.getFluxoUtilizado());
                        break;
                    }
                }
            }

            for (int v = noDestino; v != noOrigem; v = pai[v]) {
                int u = pai[v];
                for (Aresta adj : grafo.getListaAdjacencia().get(u)) {
                    if (adj.idEloCadeiaProducaoDestino == v) {
                        adj.incrementarFluxoUtilizado(fluxoCaminho);
                        fluxoArestas.put(adj, adj.getFluxoUtilizado());
                        break;
                    }
                }
            }

            fluxoMaximo += fluxoCaminho;

            for (Map.Entry<Aresta, Double> entry : fluxoArestas.entrySet()) {
                Aresta aresta = entry.getKey();
                Double fluxo = entry.getValue();
                arestasDTO.add(new ArestaDTO(
                        aresta.idEloCadeiaProducaoOrigem,
                        aresta.idEloCadeiaProducaoDestino,
                        aresta.pesoMedio,
                        fluxo));
            }
        }

        return new ResultadoEdmondsKarp(fluxoMaximo, arestasDTO);
    }

    /**
     * Classe interna para representar o resultado do algoritmo de Edmonds-Karp,
     * incluindo o fluxo máximo e o fluxo nas arestas.
     */

    public static class ResultadoEdmondsKarp {
        public final double fluxoMaximo;
        public final List<ArestaDTO> fluxoNasArestas;

        /**
         * Construtor do resultado do algoritmo de Edmonds-Karp.
         * 
         * @param fluxoMaximo     O valor do fluxo máximo encontrado.
         * @param fluxoNasArestas Uma lista contendo os detalhes dos fluxos nas arestas.
         */

        public ResultadoEdmondsKarp(double fluxoMaximo, List<ArestaDTO> fluxoNasArestas) {
            this.fluxoMaximo = fluxoMaximo;
            this.fluxoNasArestas = fluxoNasArestas;
        }
    }
}
