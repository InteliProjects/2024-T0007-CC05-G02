// package edu.inteli.a2024.m01.grupo2.planejador;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;
// import edu.inteli.a2024.m01.grupo2.planejador.models.FordFulkerson;

// public class FordFulkersonTest {

// 	@Test
// 	void testFluxoMaximoSimples() {
// 		int[][] grafo = {{0, 10, 20, 0}, {0, 0, 0, 10}, {0, 0, 0, 20}, {0, 0, 0, 0}};
// 		FordFulkerson ff = new FordFulkerson(4);
// 		assertEquals(30, ff.fordFulkerson(grafo, 0, 3), "Fluxo máximo incorreto no cenário simples.");
// 	}

// 	@Test
// 	void testFluxoMaximoComCaminhoUnico() {
// 		int[][] grafo = {{0, 15, 0}, {0, 0, 15}, {0, 0, 0}};
// 		FordFulkerson ff = new FordFulkerson(3);
// 		assertEquals(15, ff.fordFulkerson(grafo, 0, 2), "Fluxo máximo incorreto com caminho único.");
// 	}

// 	@Test
// 	void testFluxoMaximoSemCaminho() {
// 		int[][] grafo = {{0, 0}, {0, 0}};
// 		FordFulkerson ff = new FordFulkerson(2);
// 		assertEquals(0, ff.fordFulkerson(grafo, 0, 1), "Deveria haver fluxo máximo de 0 sem caminho.");
// 	}

// 	@Test
// 	void testFluxoMaximoComCaminhosParalelos() {
// 		int[][] grafo = {
// 				{0, 16, 13, 0, 0, 0},
// 				{0, 0, 10, 12, 0, 0},
// 				{0, 4, 0, 0, 14, 0},
// 				{0, 0, 9, 0, 0, 20},
// 				{0, 0, 0, 7, 0, 4},
// 				{0, 0, 0, 0, 0, 0}
// 		};
// 		FordFulkerson ff = new FordFulkerson(6);
// 		assertEquals(23, ff.fordFulkerson(grafo, 0, 5), "Fluxo máximo incorreto com caminhos paralelos.");
// 	}
// }
