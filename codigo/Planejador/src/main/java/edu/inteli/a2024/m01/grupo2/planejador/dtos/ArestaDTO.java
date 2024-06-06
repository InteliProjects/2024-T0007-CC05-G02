package edu.inteli.a2024.m01.grupo2.planejador.dtos;

/**
 * Data Transfer Object (DTO) para representar uma aresta em um digrafo,
 * incluindo detalhes como
 * o nó de origem, o nó de destino, o peso médio e o fluxo utilizado na aresta.
 * Esta classe é utilizada para transferir dados entre diferentes partes do
 * sistema, especialmente
 * para encapsular os resultados do cálculo de fluxo em redes.
 */

public class ArestaDTO {
    public int origem; // Nó de origem da aresta
    public int destino; // Nó de destino da aresta
    public double pesoMedio; // Peso médio da aresta, isto é, a capacidade de fluxo
    public double fluxoUtilizado; // Fluxo utilizado na aresta, que não necessariasmente é o total

    /**
     * Constrói uma instância de ArestaDTO com os dados fornecidos.
     *
     * @param origem         O identificador do nó de origem da aresta.
     * @param destino        O identificador do nó de destino da aresta.
     * @param pesoMedio      O peso médio associado à aresta, geralmente utilizado
     *                       para representar capacidades ou custos.
     * @param fluxoUtilizado O fluxo que está atualmente sendo utilizado na aresta,
     *                       no contexto de um cálculo de fluxo máximo ou similar.
     */

    public ArestaDTO(int origem, int destino, double pesoMedio, double fluxoUtilizado) {
        this.origem = origem;
        this.destino = destino;
        this.pesoMedio = pesoMedio;
        this.fluxoUtilizado = fluxoUtilizado;
    }
}
