package edu.inteli.a2024.m01.grupo2.planejador.controllers;

import edu.inteli.a2024.m01.grupo2.planejador.models.Aresta;
import edu.inteli.a2024.m01.grupo2.planejador.models.Digrafo;
import edu.inteli.a2024.m01.grupo2.planejador.models.EdmondsKarp;
import edu.inteli.a2024.m01.grupo2.planejador.repositories.ArestaRepository;
import edu.inteli.a2024.m01.grupo2.planejador.models.No;
import edu.inteli.a2024.m01.grupo2.planejador.repositories.NoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Arrays;
import java.util.List;

/**
 * Controlador REST dedicado à execução e gestão do algoritmo de Edmonds-Karp.
 * Este controlador é responsável por criar uma instância do grafo baseado nos
 * dados persistidos,
 * e aplicar o algoritmo de Edmonds-Karp para calcular o fluxo máximo entre dois
 * nós.
 */
@RestController
public class EdmondsKarpController {
    private Digrafo digrafo;
    private final NoRepository noRepository;
    private final ArestaRepository arestaRepository;

    /**
     * Constrói o controlador, inicializando o repositório de arestas e nós.
     * Imediatamente após a inicialização, o grafo é construído a partir dos dados
     * presentes nos repositórios.
     * 
     * @param arestaRepository O repositório de arestas utilizado para construir as
     *                         conexões no grafo.
     * @param noRepository     O repositório de nós utilizado para determinar a
     *                         quantidade de vértices no grafo.
     */
    public EdmondsKarpController(ArestaRepository arestaRepository, NoRepository noRepository) {

        this.arestaRepository = arestaRepository;
        this.noRepository = noRepository;

        construirGrafo();
    }

    /**
     * Constrói o grafo baseado nos nós e arestas disponíveis nos repositórios.
     * Este método é chamado durante a inicialização do controlador para preparar o
     * grafo para o algoritmo de Edmonds-Karp.
     */
    private void construirGrafo() {
        List<Integer> clientes = Arrays.asList(2422, 2436, 2438, 2283, 1186, 1187, 1189, 1248, 1191, 1193, 1196, 1199, 1200, 1201, 1552, 1214, 1215, 1217, 1218, 1308, 1086, 1087, 1551, 1560, 1925, 1810, 1933, 1934, 1053, 1054, 1682, 1937, 1938, 1941, 1943, 1945, 1692, 1694, 1695, 3269, 3270, 3271, 3272, 1654, 3341, 1656, 3342, 3343, 3344, 1205, 3346, 3347, 3348, 3349, 1210, 1211, 3352, 3353, 3354, 1666, 2152, 2176, 2284, 3355, 2167, 3356, 2171, 3357, 3358, 3359, 2206, 3360, 3361, 2282, 2285, 2192, 1958, 1740, 1742, 1743, 2079, 2064, 2055, 1910, 2009, 1972, 2010, 3362, 1829, 2241, 1831, 2094, 2096, 2124, 2158, 2291, 2292, 2293, 2295, 2297, 2308, 2309, 2332, 2338, 3317, 3318, 2716, 2717, 3280, 3281, 3285, 3286, 3287, 3288, 3289, 3290, 3291, 3008, 3019, 3020, 2908, 2909, 2994, 2995, 3024, 1741, 3035, 3038, 1052, 3051, 3060, 3085, 3086, 3087, 3279, 3142, 3273, 3274, 3146, 3275, 3276, 3277, 3170, 3339, 3278, 3340, 3088, 3350, 3111, 3112, 3221, 3222, 3227, 3228, 3237, 3309, 3092, 3364, 3094, 3370, 3371, 3372, 3098, 3373, 3374, 3101, 3375, 3376, 3377, 2013, 2331, 3207, 3211, 3212, 3213, 3214, 3215, 3216, 3219, 3220, 3232, 3233, 3260, 3264, 1653, 1168, 3130, 3155, 3156, 3158, 3160, 3173, 3175, 3176, 3179, 3185, 3186, 3188, 3196, 3197, 3198, 3199, 3206, 3167, 3171, 3184, 3304, 3190, 3191, 3192, 3193, 3194, 3256, 3255, 3265, 3305, 3306, 3307, 3308, 3310, 3321, 3322, 3331, 3332, 3338);
        List<Integer> usinas = Arrays.asList(1818, 1011, 1012, 1013, 1017, 2117, 2122, 1014, 1020, 2189, 2203, 3351);
        int nos = (int) this.noRepository.count();
        Iterable<Aresta> arestas = this.arestaRepository.findAll();

        Digrafo grafo = new Digrafo(nos);

        for (Aresta aresta : arestas) {
            grafo.adicionarAresta((int) aresta.idEloCadeiaProducaoOrigem, (int) aresta.idEloCadeiaProducaoDestino,
                    aresta.pesoMedio, aresta.codigoSubModal, aresta.codigoTipoModal, aresta.descricao);

            //ID 999999 é o id da superfone
            if (usinas.contains((int) aresta.idEloCadeiaProducaoOrigem)) {
                grafo.adicionarAresta((int) 999999, (int) aresta.idEloCadeiaProducaoOrigem, 99999999999999999999999999999D, "Superfonte", "Superfonte", "Superfonte");
            }

            //ID 999998 é o id do supersorvedouro
            if (clientes.contains((int) aresta.idEloCadeiaProducaoDestino)) {
                grafo.adicionarAresta((int) aresta.idEloCadeiaProducaoDestino, (int) 999998, 99999999999999999999999999999D, "Supersorvedouro", "Supersorvedouro", "Supersorvedouro");
            }
        }

        this.digrafo = grafo;
    }

    /**
     * Endpoint para executar o algoritmo de Edmonds-Karp sobre o grafo construído e
     * retornar o resultado.
     * Habilita a origem cruzada (CORS) para permitir solicitações de diferentes
     * origens.
     * 
     * @return O resultado do algoritmo de Edmonds-Karp, incluindo o fluxo máximo e
     *         detalhes das arestas.
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
            RequestMethod.PUT, RequestMethod.DELETE })
    @GetMapping("/EdmondsKarp")
    public EdmondsKarp.ResultadoEdmondsKarp testar() {
        int nos = (int) this.noRepository.count();
        EdmondsKarp ek = new EdmondsKarp(this.digrafo, 0, (nos - 1));
        EdmondsKarp.ResultadoEdmondsKarp resultado = ek.edmondsKarp();

        return resultado;
    }
}
