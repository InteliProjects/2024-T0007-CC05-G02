package edu.inteli.a2024.m01.grupo2.planejador;

import edu.inteli.a2024.m01.grupo2.planejador.models.Aresta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArestaTest {

    private Aresta aresta;

    @BeforeEach
    void setUp() {
        aresta = new Aresta("codigoSubModal", "codigoTipoModal", "descricao", 1, 2, 100.0);
    }

    @Test
    void testConstructorPositiveWeight() {
        assertDoesNotThrow(() -> new Aresta("subModal", "tipoModal", "Teste", 1, 2, 50.0));
    }

    @Test
    void testConstructorThrowsExceptionForNegativeWeight() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Aresta("subModal", "tipoModal", "Teste", 1, 2, -1.0));
        assertEquals("Peso não pode ser negativo", exception.getMessage());
    }

    @Test
    void testSetAndGetFluxoUtilizado() {
        aresta.setFluxoUtilizado(50.0);
        assertEquals(50.0, aresta.getFluxoUtilizado(), "O fluxo utilizado deve ser 50");
    }

    @Test
    void testIncrementarFluxoUtilizado() {
        aresta.incrementarFluxoUtilizado(20.0);
        assertEquals(20.0, aresta.getFluxoUtilizado(), "O fluxo utilizado deve ser incrementado para 20");
    }

    @Test
    void testToString() {
        String expected = "Aresta{origem=1, destino=2, pesoMedio=100,00, fluxoUtilizado=0,00}";
        assertEquals(expected, aresta.toString(), "A saída do toString deve corresponder ao formato esperado");
    }

}
