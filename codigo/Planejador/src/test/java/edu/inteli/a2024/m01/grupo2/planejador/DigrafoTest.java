import edu.inteli.a2024.m01.grupo2.planejador.models.Aresta;
import edu.inteli.a2024.m01.grupo2.planejador.models.Digrafo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DigrafoTest {

    private Digrafo digrafo;

    @BeforeEach
    void setUp() {
        digrafo = new Digrafo(3);
    }

    @Test
    void constructorCorrectlyInitializesAdjacencyList() {
        assertEquals(3, digrafo.getQuantidadeNos(), "Deve haver 3 nós no dígrafo.");
        assertEquals(3, digrafo.getListaAdjacencia().size(), "A lista de adjacência deve ter 3 listas.");
    }

    @Test
    void adicionarArestaCorrectlyAddsEdge() {
        digrafo.adicionarAresta(0, 1, 100.0, "subModal", "tipoModal", "descricao");
        List<List<Aresta>> listaAdj = digrafo.getListaAdjacencia();

        assertFalse(listaAdj.get(0).isEmpty(), "A lista de adjacência do nó 0 não deve estar vazia.");
        assertEquals(1, listaAdj.get(0).get(0).idEloCadeiaProducaoDestino, "A aresta deve apontar para o nó 1.");
        assertEquals(100.0, listaAdj.get(0).get(0).pesoMedio, 0.01, "O peso da aresta deve ser 100.");
    }

    @Test
    void getQuantidadeNosReturnsCorrectNumber() {
        assertEquals(3, digrafo.getQuantidadeNos(), "A quantidade de nós deve ser 3.");
    }

    @Test
    void getListaAdjacenciaReturnsCorrectList() {
        assertNotNull(digrafo.getListaAdjacencia(), "A lista de adjacência não deve ser nula.");
        assertEquals(3, digrafo.getListaAdjacencia().size(), "A lista de adjacência deve conter 3 listas.");
    }
}
