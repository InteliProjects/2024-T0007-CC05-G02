package edu.inteli.a2024.m01.grupo2.planejador.models;

import java.util.*;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Representa um grafo direcionado (digrafo) para modelar redes de logística ou
 * cadeias de produção.
 * Esta estrutura é usada para armazenar nós e arestas com pesos, permitindo
 * representar relações e fluxos entre diferentes pontos.
 */
public class Digrafo {
    /**
     * Estrutura para armazenar as listas de adjacência. Cada lista contém as
     * arestas que saem de um vértice específico.
     */
    private List<List<Aresta>> listaAdjacencia;

    /**
     * Quantidade total de nós (vértices) no digrafo.
     */
    private int quantidadeNos;

    /**
     * Constrói um digrafo com uma quantidade específica de nós.
     * 
     * @param quantidadeNos O número total de nós no digrafo.
     */
    public Digrafo(int quantidadeNos) {
        this.listaAdjacencia = new ArrayList<>(quantidadeNos);
        this.quantidadeNos = quantidadeNos;

        this.listaAdjacencia.add(new LinkedList<>());

        for (int i = 0; i < quantidadeNos; i++) {
            listaAdjacencia.add(new LinkedList<>());
        }

        this.listaAdjacencia.add(new LinkedList<>());
    }

    /**
     * Adiciona uma aresta direcionada ao digrafo.
     * 
     * @param idEloCadeiaProducaoOrigem  O ID do nó de origem da aresta.
     * @param idEloCadeiaProducaoDestino O ID do nó de destino da aresta.
     * @param pesoMedio                  O peso (capacidade) associado à aresta.
     * @param codigoSubModal             O código do submodal associado à aresta.
     * @param codigoTipoModal            O código do tipo modal associado à aresta.
     * @param descricao                  Uma descrição da aresta.
     */
    public void adicionarAresta(int idEloCadeiaProducaoOrigem, int idEloCadeiaProducaoDestino, double pesoMedio,
            String codigoSubModal, String codigoTipoModal, String descricao) {

        this.listaAdjacencia.get(idEloCadeiaProducaoOrigem).add(new Aresta(codigoSubModal, codigoTipoModal, descricao,
                idEloCadeiaProducaoOrigem, idEloCadeiaProducaoDestino, pesoMedio));
    }

    /**
     * Retorna a quantidade total de nós no digrafo.
     * 
     * @return A quantidade de nós.
     */
    public int getQuantidadeNos() {
        return this.quantidadeNos;
    }

    /**
     * Fornece acesso à lista de adjacência do digrafo.
     * 
     * @return A lista de adjacência, onde cada elemento é uma lista de arestas que
     *         saem de um vértice específico.
     */
    public List<List<Aresta>> getListaAdjacencia() {
        return this.listaAdjacencia;
    }

    /**
     * Imprime a representação do grafo no console. Útil para depuração e
     * visualização do estado atual do digrafo. Não é tão prático de se utilizar se
     * tiver um dígrafo grande.
     */
    public void imprimirGrafo() {
        for (int i = 0; i < listaAdjacencia.size(); i++) {
            List<Aresta> lista = listaAdjacencia.get(i);
            for (Aresta aresta : lista) {
                System.out.println("Vértice " + i + " está conectado ao vértice " +
                        aresta.idEloCadeiaProducaoDestino + " com peso " + aresta.pesoMedio);
            }
        }
    }
}
