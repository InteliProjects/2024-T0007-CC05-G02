package edu.inteli.a2024.m01.grupo2.planejador.models;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Representa um nó (vértice) dentro do modelo de digrafo
 * Anotado como uma entidade JPA para persistência no banco de dados.
 */
@Entity
public class No {
    public No() { }
    public No(int id, String tipoElo, int capacidadeMaximaEstocagem, String descricao, boolean temEstoque) {
        this.id = id;
        this.tipoElo = tipoElo;
        this.capacidadeMaximaEstocagem = capacidadeMaximaEstocagem;
        this.descricao = descricao;
        this.temEstoque = temEstoque;
    }

    /**
     * Identificador único do nó, gerado automaticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    /**
     * Tipo do elo que o nó representa, não pode ser nulo. (Ex: Cliente, Usina de
     * Beneficiamento, etc)
     */
    @Nonnull
    public String tipoElo;

    /**
     * Capacidade máxima de estocagem do nó. Pode ser nulo se o nó não tiver
     * capacidade de estocagem.
     */
    @Nullable
    public Integer capacidadeMaximaEstocagem;

    /**
     * Descrição do nó, não pode ser nulo. (Inclue nome e pode incluir outras
     * informações, como tipo do Elo)
     */
    @Nonnull
    public String descricao;

    /**
     * Indica se o nó possui capacidade de estocagem.
     */
    public boolean temEstoque;
}
