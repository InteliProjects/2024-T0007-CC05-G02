package edu.inteli.a2024.m01.grupo2.planejador.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import edu.inteli.a2024.m01.grupo2.planejador.dtos.ArestaDTO;

/**
 * Implementação do algoritmo de Ford-Fulkerson para encontrar o fluxo máximo em um grafo
 */
public class FordFulkerson {
    private double[][] capacidadeRestante;
    private double[][] fluxo;
    private Digrafo digrafo;

    public FordFulkerson(Digrafo digrafo) {
        this.digrafo = digrafo;
        int n = digrafo.getQuantidadeNos();
        this.capacidadeRestante = new double[n][n];
        this.fluxo = new double[n][n];
        // Initialize capacities from the graph
        for (List<Aresta> arestas : digrafo.getListaAdjacencia()) {
            for (Aresta aresta : arestas) {
                capacidadeRestante[aresta.idEloCadeiaProducaoOrigem][aresta.idEloCadeiaProducaoDestino] = aresta.pesoMedio;
            }
        }
    }


    /**
     * Realize a Busca em Largura (BFS) para encontrar um caminho de origem a destino
     * @param origem ID do Nó de origem
     * @param destino ID do Nó de destino
     * @param pais IDs dos nós pais
     * @return True se encontrada um caminho de origem a destino, False caso contrário
     */
    boolean buscaLargura(int origem, int destino, int[] pais) {
        boolean[] visitados = new boolean[digrafo.getQuantidadeNos()];
        Queue<Integer> fila = new LinkedList<>();
        fila.add(origem);
        visitados[origem] = true;
        pais[origem] = -1;

        while (!fila.isEmpty()) {
            int u = fila.poll();
            for (Aresta aresta : digrafo.getListaAdjacencia().get(u)) {
                int v = aresta.idEloCadeiaProducaoDestino;
                if (!visitados[v] && capacidadeRestante[u][v] > 0) {
                    fila.add(v);
                    pais[v] = u;
                    visitados[v] = true;
                    if (v == destino) return true;
                }
            }
        }
        return false;
    }

    /**
     * Encontre o fluxo máximo de origem a destino
     * @param origem ID do Nó de origem
     * @param destino ID do Nó de destino
     * @return O fluxo máximo e o fluxo nas arestas
     */
    public ResultadoFordFulkerson fordFulkerson(int origem, int destino) {
        int[] pais = new int[digrafo.getQuantidadeNos()];
        double fluxoMaximo = 0;

        while (buscaLargura(origem, destino, pais)) {
            double fluxoCaminho = Double.MAX_VALUE;
            for (int v = destino; v != origem; v = pais[v]) {
                int u = pais[v];
                fluxoCaminho = Math.min(fluxoCaminho, capacidadeRestante[u][v]);
            }

            for (int v = destino; v != origem; v = pais[v]) {
                int u = pais[v];
                capacidadeRestante[u][v] -= fluxoCaminho;
                capacidadeRestante[v][u] += fluxoCaminho;
                fluxo[u][v] += fluxoCaminho;
                fluxo[v][u] -= fluxoCaminho;
            }

            fluxoMaximo += fluxoCaminho;
        }

        List<ArestaDTO> arestasDTO = new ArrayList<>();
        for (int u = 0; u < digrafo.getQuantidadeNos(); u++) {
            for (Aresta aresta : digrafo.getListaAdjacencia().get(u)) {
                int v = aresta.idEloCadeiaProducaoDestino;
                double fluxoAtual = fluxo[u][v];
                if (fluxoAtual > 0) {
                    arestasDTO.add(new ArestaDTO(
                        aresta.idEloCadeiaProducaoOrigem,
                        aresta.idEloCadeiaProducaoDestino,
                        aresta.pesoMedio,
                        fluxoAtual));
                }
            }
        }

        return new ResultadoFordFulkerson(fluxoMaximo, arestasDTO);
    }

    /**
     * Resultado do algoritmo de Ford-Fulkerson
     */
    public static class ResultadoFordFulkerson {
        public final double fluxoMaximo;
        public final List<ArestaDTO> fluxoNasArestas;

        public ResultadoFordFulkerson(double fluxoMaximo, List<ArestaDTO> fluxoNasArestas) {
            this.fluxoMaximo = fluxoMaximo;
            this.fluxoNasArestas = fluxoNasArestas;
        }
    }
}
