package edu.inteli.a2024.m01.grupo2.planejador.models;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementação do algoritmo de Edmonds-Karp para encontrar o fluxo máximo em um grafo
 */
public class EdmondsKarpService {
    private Digrafo grafo;
    private int[] pai;
    private int noOrigem;
    private int noDestino;

    public EdmondsKarpService(Digrafo grafo, int noOrigem, int noDestino) {
        this.grafo = grafo;
        this.noOrigem = noOrigem;
        this.noDestino = noDestino;
        this.pai = new int[grafo.getQuantidadeNos()];
    }

    /**
     * Busca em largura para encontrar um caminho de noOrigem até noDestino
     *
     * @return true se encontrou um caminho, false caso contrário
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
     * Algoritmo de Edmonds-Karp para encontrar o fluxo máximo de noOrigem até noDestino
     * @return Fluxo Máximo
     */
    public double edmondsKarp() {
        double fluxoMaximo = 0;

        while (buscaLargura()) {
            double fluxoCaminho = Double.MAX_VALUE;

            for (int v = noDestino; v != noOrigem; v = pai[v]) {
                int u = pai[v];
                for (Aresta adj : grafo.getListaAdjacencia().get(u)) {
                    if (adj.idEloCadeiaProducaoDestino == v) {
                        fluxoCaminho = Math.min(fluxoCaminho, adj.pesoMedio - adj.fluxoMaximo);
                        break;
                    }
                }
            }

            for (int v = noDestino; v != noOrigem; v = pai[v]) {
                int u = pai[v];
                for (Aresta adj : grafo.getListaAdjacencia().get(u)) {
                    if (adj.idEloCadeiaProducaoDestino == v) {
                        adj.incrementarFluxoUtilizado(fluxoCaminho);
                        break;
                    }
                }
            }

            fluxoMaximo += fluxoCaminho;
        }

        return fluxoMaximo;
    }
}
