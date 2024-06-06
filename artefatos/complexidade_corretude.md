# Complexidade e corretude do algoritmo

&emsp;&emsp;Neste documento, serão abordados dois temas relacionados ao contexto da análise de algoritmos: a complexidade e a corretude, que serão aplicados na implementação do algoritmo de Edmonds-Karp, que foi um dos algoritmos clássicos na abordagem de fluxo máximo. Inicialmente, será feita uma breve análise quanto à questão de complexidade de tempo no melhor e pior caso utilizando a notação _Big O_. Além disso, no que tange à avaliação de corretude, haverá a determinação do invariante do laço principal para cada um dos algoritmos. Por fim, haverá uma demonstração formal da corretude, aplicando a indução matemática no invariante.

&emsp;&emsp; A complexidade de tempo de execução de um algoritmo é uma métrica utilizada para estimar o tempo necessário para a execução dele, variando com base no tamanho da entrada. Neste documento, em específico, faremos essa medição utilizando a notação _Big O_ na qual expressamos a complexidade de tempo através de _O(n)_, sendo que _n_ representa o tamanho da entrada, e o termo dentro dos parênteses indica como o tempo de execução escala. Nesse sentido, um algoritmo de complexidade _O(n)_ é mais eficiente do que um outro que apresente complexidade $O(n^2)$ ou $O(n!)$, por exemplo. Neste documento, a avaliação de complexidade será realizada para a implementação do algoritmo de Edmonds-Karp feita por esse grupo, cujo código é exibido a seguir.

```
public class EdmondsKarp {
    private Digrafo grafo;
    private int[] pai;
    private int noOrigem;
    private int noDestino;

    public EdmondsKarp(Digrafo grafo, int noOrigem, int noDestino) {
        this.grafo = grafo;
        this.noOrigem = noOrigem;
        this.noDestino = noDestino;
        this.pai = new int[grafo.getQuantidadeNos()];
    }

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

    public ResultadoEdmondsKarp edmondsKarp() {
      double fluxoMaximo = 0;
      Map<Aresta, Double> fluxoArestas = new HashMap<>();
      List<ArestaDTO> arestasDTO = new ArrayList<>();

      while (buscaLargura()) {
          double fluxoCaminho = Double.MAX_VALUE;

          for (int v = noDestino; v != noOrigem; v = pai[v]) {
              int u = pai[v];
              for (Aresta adj : grafo.getListaAdjacencia().get(u)) {
                  if (adj.idEloCadeiaProducaoDestino == v) {
                      fluxoCaminho = Math.min(fluxoCaminho, adj.pesoMedio - adj.getFluxoUtilizado());
                      break;
                  }
              }
          }

          for (int v = noDestino; v != noOrigem; v = pai[v]) {
              int u = pai[v];
              for (Aresta adj : grafo.getListaAdjacencia().get(u)) {
                  if (adj.idEloCadeiaProducaoDestino == v) {
                      adj.incrementarFluxoUtilizado(fluxoCaminho);
                      fluxoArestas.put(adj, adj.getFluxoUtilizado());
                      break;
                  }
              }
          }

          fluxoMaximo += fluxoCaminho;

          for (Map.Entry<Aresta, Double> entry : fluxoArestas.entrySet()) {
              Aresta aresta = entry.getKey();
              Double fluxo = entry.getValue();
              arestasDTO.add(new ArestaDTO(
                      aresta.idEloCadeiaProducaoOrigem,
                      aresta.idEloCadeiaProducaoDestino,
                      aresta.pesoMedio,
                      fluxo));
          }
      }

      return new ResultadoEdmondsKarp(fluxoMaximo, arestasDTO);
  }
    public static class ResultadoEdmondsKarp {
        public final double fluxoMaximo;
        public final List<ArestaDTO> fluxoNasArestas;

        public ResultadoEdmondsKarp(double fluxoMaximo, List<ArestaDTO> fluxoNasArestas) {
            this.fluxoMaximo = fluxoMaximo;
            this.fluxoNasArestas = fluxoNasArestas;
        }
    }
}
```

&emsp;&emsp;Para podermos mensurar qual a complexidade desse código, é preciso dividir o algoritmo em duas partes, a do método _buscaLargura()_ e a do método _edmondsKarp()_.

&emsp;&emsp;O primeiro destes métodos, que, como o próprio nome sugere, consiste em realizar uma busca em largura, executa a partir do nó de origem até que todos os nós alcançáveis sejam visitados ou até que o nó de destino seja encontrado. A complexidade dessa parte depende do número _V_ de vértices e do número _E_ de arestas. Para cada iteração, cada vértice é enfileirado e desenfileirado exatamente uma vez, e todas as arestas adjacentes são examinadas. Assim, podemos dizer que a complexidade é $O(V+E)$.

&emsp;&emsp;Ao partir para o método principal (_edmondsKarp()_), ele a busca em largura enquanto for possível encontrar um caminho de aumento. O pior cenário ocorre quando o fluxo máximo é aumentado em uma unidade a cada iteração do loop. E, conforme Kawakami (2017) elucida, o número de iterações (ou seja, o número de caminhos de aumento encontrados) é limitado pelo produto de _V_ e _E_, haja vista que cada aresta pode contribuir com, no máximo, uma unidade ao fluxo total e o número máximo de aumentos é limitado pelo produto do número de vértices e arestas.

&emsp;&emsp;Portanto, a complexidade total do algoritmo Edmonds-Karp é o produto da complexidade de uma única execução da busca em largura $(O(V+E))$ pelo número máximo de iterações $(O(VE))$, culminando em uma complexidade de $(O(VE^2))$, que pode ser mensurada como a complexidade para o pior caso. O melhor caso para este algoritmo ocorre quando o primeiro caminho aumentante encontrado é também o caminho que maximiza o fluxo no grafo, ou seja, quando não são necessárias iterações adicionais após a primeira busca em largura. Nesse caso, a complexidade seria simplesmente $O(V+E)$, correspondendo a uma única execução da busca em largura.

&emsp;&emsp;Já em se tratando da corretude, assim como apontado por Cormen (2012), a corretude de um algoritmo diz respeito à sua capacidade de resolver corretamente o problema para o qual foi projetado, ou seja, se ele sempre produz a saída correta para qualquer entrada válida. A demonstração da corretude de um algoritmo geralmente envolve a prova de duas propriedades: a propriedade de terminação, que garante que o algoritmo sempre termina sua execução, e a propriedade de validade, que assegura que, ao terminar, o algoritmo produz a saída correta. Neste documento, será provada a corretude para o seguinte fragmento de código do algoritmo de Edmonds-Karp:

```
public ResultadoEdmondsKarp edmondsKarp() {
        double fluxoMaximo = 0;
        Map<Aresta, Double> fluxoArestas = new HashMap<>();
        List<ArestaDTO> arestasDTO = new ArrayList<>();

        while (buscaLargura()) {
            double fluxoCaminho = Double.MAX_VALUE;

            for (int v = noDestino; v != noOrigem; v = pai[v]) {
                int u = pai[v];
                for (Aresta adj : grafo.getListaAdjacencia().get(u)) {
                    if (adj.idEloCadeiaProducaoDestino == v) {
                        fluxoCaminho = Math.min(fluxoCaminho, adj.pesoMedio - adj.getFluxoUtilizado());
                        break;
                    }
                }
            }

            for (int v = noDestino; v != noOrigem; v = pai[v]) {
                int u = pai[v];
                for (Aresta adj : grafo.getListaAdjacencia().get(u)) {
                    if (adj.idEloCadeiaProducaoDestino == v) {
                        adj.incrementarFluxoUtilizado(fluxoCaminho);
                        fluxoArestas.put(adj, adj.getFluxoUtilizado());
                        break;
                    }
                }
            }

            fluxoMaximo += fluxoCaminho;

            for (Map.Entry<Aresta, Double> entry : fluxoArestas.entrySet()) {
                Aresta aresta = entry.getKey();
                Double fluxo = entry.getValue();
                arestasDTO.add(new ArestaDTO(
                        aresta.idEloCadeiaProducaoOrigem,
                        aresta.idEloCadeiaProducaoDestino,
                        aresta.pesoMedio,
                        fluxo));
            }
        }

        return new ResultadoEdmondsKarp(fluxoMaximo, arestasDTO);
    }
```

&emsp;&emsp;Nesse laço, o invariante consiste no fato de que, a cada iteração, o fluxo máximo no grafo é incrementado pela quantidade do fluxo mínimo encontrado no caminho de aumento atual, mantendo a capacidade de todas as arestas atualizada com os novos fluxos utilizados. Podemos representar isso de maneira matemática, vamos considerar as seguintes variáveis:

- $f$ é o fluxo atual no grafo;
- $c(u, v)$ é a capacidade da aresta partindo do nó u e indo até o nó v
- $f(u, v)$ é o fluxo atual na aresta partindo do nó u e indo até o nó v
- $c_f(u, v)$ é a capacidade residual na aresta que parte do nó u e vai até o nó v (isso é definido como  $c(u, v) - f(u, v)$) 
- $P$ é um caminho aumentante
- $\Delta f$ é o fluxo mínimo encontrado em um caminho aumentante qualquer, ou seja, $\Delta f = min_{(u, v) \in P}c(u, v)$

&emsp;&emsp;Sendo assim, conseguimos expressar a invariante da seguinte maneira:

- **Antes e depois de cada iteração do laço**, o fluxo $f$ da rede é viável, ou seja, para todas as arestas $(u, v)$, tem-se $0 \leq f(u, v) \leq c(u, v)$.

- **Após cada iteração do laço**, o fluxo máximo da rede, $f_{\text{max}}$, é incrementado por $\Delta f$, o que é o fluxo mínimo encontrado no caminho de aumento. Então, se $f_{\text{antes}}^{\text{max}}$ é o fluxo máximo antes da iteração e $f_{\text{depois}}^{\text{max}}$ é o fluxo máximo depois da iteração, então $f_{\text{depois}}^{\text{max}} = f_{\text{antes}}^{\text{max}} + \Delta f$.

- **A capacidade residual das arestas** no caminho de aumento $P$ é atualizada para refletir o novo fluxo passando por elas. Para cada aresta $(u, v) \in P$, a nova capacidade residual $c_{f}^{\text{nova}}(u, v) = c_{f}^{\text{antiga}}(u, v) - \Delta f$ para arestas diretas, e $c_{f}^{\text{nova}}(v, u) = c_{f}^{\text{antiga}}(v, u) + \Delta f$ para arestas reversas.

&emsp;&emsp; Esse processo termina quando não há mais caminhos de aumento possíveis, o que significa que o fluxo máximo $f_{max}$​ não pode mais ser incrementado, indicando que foi alcançado o fluxo máximo possível dentro das restrições de capacidade do grafo. Agora, podemos tentar provar esse invariante utilizando indução:

- **Base da indução**: Considerando que ainda não houveram iterações, isto é $(n = 0)$, o fluxo total na rede é 0. Ou seja, Para $n=0$ temos que ${f_{max} = 0}$, o que está correto, haja vista que não há fluxo pré-existente a ser incrementado.

- **Hipótese da indução**: Para $n=k$, podemos assumir que $f_{max}^{(k)}$ consiste no fluxo máximo alcançado pela soma da quantidade $k$ de $\Delta f$ encontrados até então.

- **Passo indutivo**:  Precisamos provar que para $ n = k+1$, temos que $f_{max}^{(k+1)} = f_{max}^{(k)} + \Delta f^{(k+1)}$, donde $\Delta f^{(k+1)}$ é o fluxo mínimo no $(k+1)$-ésimo caminho de aumentante. Para tanto, temos:

1. Encontrar Caminho de Aumento para $n=k+1$:
    - Um caminho de aumento $P^{(k+1)}$ é encontrado com capacidade residual positiva: $\forall (u,v) \in P^{(k+1)}, c_f(u,v) > 0$.

    - Definimos $\Delta f^{(k+1)} = \min_{(u,v) \in P^{(k+1)}} c_f(u,v)$.

2. Atualizar $f_{max}$ e Capacidades Residuais:

   - Atualizar Fluxo Máximo: $f_{max}^{(k+1)} = f_{max}^{(k)} + \Delta f^{(k+1)}$.
   - Atualizar Capacidades Residuais: Para cada aresta $(u,v) \in P^{(k+1)}$,temos que $c_f(u,v) = c_f(u,v) - \Delta f^{(k+1)}$.

Assim, mostramos que $f_{max}$ é incrementado corretamente, mantendo o invariante de que o fluxo máximo reflete a soma dos fluxos mínimos dos caminhos de aumento até $n=k+1$, como queríamos demonstrar.

# Referências

CORMEN, Thomas H. et al. Algoritmos: teoria e prática. 3. ed. Porto Alegre: Bookman, 2012.
  
KAWAKAMi, Marcos Massayuki. Algoritmos em redes de fluxo e aplicações. São Paulo: Universidade de São Paulo, Instituto de Matemática e Estatística, 2017. Disponível em: <https://linux.ime.usp.br/~marcosk/mac0499/files/monografia.pdf>. Acesso em: 29 mar. 2024.

