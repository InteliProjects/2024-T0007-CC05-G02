package edu.inteli.a2024.m01.grupo2.planejador;

import edu.inteli.a2024.m01.grupo2.planejador.models.EdmondsKarp;
import edu.inteli.a2024.m01.grupo2.planejador.models.Digrafo;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EdmondsKarpTest {

    private Digrafo testGraph;
    private EdmondsKarp algorithm;

    @Before
    public void setUp() {
        testGraph = new Digrafo(10);
    }

    @Test
    public void testEdmondsKarpSimpleCase() {
        algorithm = new EdmondsKarp(testGraph, 0, 2);
        EdmondsKarp.ResultadoEdmondsKarp result = algorithm.edmondsKarp();
        double expectedMaxFlow = 10.0;
        assertEquals(expectedMaxFlow, result.fluxoMaximo, 0.001);
    }

    @Test
    public void testNoPath() {
        algorithm = new EdmondsKarp(testGraph, 0, 3);
        EdmondsKarp.ResultadoEdmondsKarp result = algorithm.edmondsKarp();
        double expectedMaxFlow = 0.0;
        assertEquals(expectedMaxFlow, result.fluxoMaximo, 0.001);
    }

    @Test
    public void testWithMultiplePaths() {
        algorithm = new EdmondsKarp(testGraph, 0, 4);
        EdmondsKarp.ResultadoEdmondsKarp result = algorithm.edmondsKarp();
        double expectedMaxFlow = 25.0;
        assertEquals(expectedMaxFlow, result.fluxoMaximo, 0.001);
    }

    @Test
    public void testGraphWithLoops() {
        algorithm = new EdmondsKarp(testGraph, 0, 5);
        EdmondsKarp.ResultadoEdmondsKarp result = algorithm.edmondsKarp();
        double expectedMaxFlow = 15.0;
        assertEquals(expectedMaxFlow, result.fluxoMaximo, 0.001);
    }

    @Test
    public void testMinimalGraph() {
        algorithm = new EdmondsKarp(testGraph, 0, 1);
        EdmondsKarp.ResultadoEdmondsKarp result = algorithm.edmondsKarp();
        double expectedMaxFlow = 5.0;
        assertEquals(expectedMaxFlow, result.fluxoMaximo, 0.001);
    }
}
