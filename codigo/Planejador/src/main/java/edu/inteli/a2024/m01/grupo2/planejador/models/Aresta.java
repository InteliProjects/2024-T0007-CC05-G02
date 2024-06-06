package edu.inteli.a2024.m01.grupo2.planejador.models;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Representa a ligação entre dois pontos A e B por uma aresta (modal). Estes pontos podem ser usinas de beneficiamento, usinas de pelotagem, portos, etc.
 * Esta classe possui apenas getters e setters.
 */

@Entity
public class Aresta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Nonnull
    public String codigoSubModal;

    @Nonnull
    public String codigoTipoModal;

    @Nonnull
    public String descricao;

    @Nonnull
    public Integer idEloCadeiaProducaoOrigem;

    @Nonnull
    public Integer idEloCadeiaProducaoDestino;

    @Nonnull
    public Double pesoMedio;

    @Nullable
    public Double fluxoMaximo;

    public Aresta() {}

    /**
     * Construtor da classe Aresta
     *
     * @param codigoSubModal       Código da submodalidade de transporte
     * @param codigoTipoModal      Código do tipo de transporte
     * @param descricao           Descrição do transporte
     * @param idEloCadeiaProducaoOrigem Identificador do elo da cadeia de produção de origem
     * @param idEloCadeiaProducaoDestino  Identificador do elo da cadeia de produção de destino
     * @param pesoMedio           Peso médio do transporte
     * @throws IllegalArgumentException Se o peso médio for negativo
     */
    public Aresta(@Nonnull String codigoSubModal, @Nonnull String codigoTipoModal, @Nonnull String descricao, int idEloCadeiaProducaoOrigem, int idEloCadeiaProducaoDestino, @Nonnull Double pesoMedio) {
        this.codigoSubModal = codigoSubModal;
        this.codigoTipoModal = codigoTipoModal;
        this.descricao = descricao;
        this.idEloCadeiaProducaoOrigem = idEloCadeiaProducaoOrigem;
        this.idEloCadeiaProducaoDestino = idEloCadeiaProducaoDestino;
        this.pesoMedio = pesoMedio;
        this.fluxoMaximo = 0.0;

        if (pesoMedio < 0) throw new IllegalArgumentException("Peso não pode ser negativo");
    }

    @Nullable
    private double fluxoUtilizado;

    public double getFluxoUtilizado() {
        return this.fluxoUtilizado;
    }

    public void setFluxoUtilizado(double fluxoUtilizado) {
        if (this.fluxoUtilizado < 0) throw new IllegalArgumentException("Peso não pode ser negativo");
        this.fluxoUtilizado = fluxoUtilizado;
    }

    public void incrementarFluxoUtilizado(double fluxoUtilizado) {
        this.fluxoUtilizado = fluxoUtilizado;
    }

    @Override
    public String toString() {
        return String.format("Aresta{origem=%d, destino=%d, pesoMedio=%.2f, fluxoUtilizado=%.2f}",
                idEloCadeiaProducaoOrigem, idEloCadeiaProducaoDestino, pesoMedio, fluxoUtilizado);
    }
}
