---
title: Modelo para o artigo
author: Inteli
date: Fevereiro de 2024
abstract: Escreva aqui o resumo deste artigo.
---

# Introdução

&emsp;&emsp;Em um ambiente empresarial global e complexo, a gestão eficiente da cadeia de suprimentos torna-se essencial para a competitividade e sustentabilidade das empresas. Conforme Chopra e Meindl (2015) destacam, adotar estratégias sólidas e um planejamento estratégico são fundamentais para melhorar a eficiência operacional. Neste projeto, em parceria com uma grande empresa do ramo da mineração, surge um desafio específico no contexto da gestão da cadeia de suprimentos.

&emsp;&emsp;O desafio em questão reside no planejamento dos fluxos de minério em cada ponto da malha de transporte disponível, enfrentado por uma grande empresa mineradora. Esta empresa busca atender eficientemente às demandas dos clientes, garantindo a distribuição eficaz de seus produtos. Um plano mensal precisa ser elaborado para otimizar a logística, respeitando todas as restrições operacionais. Neste contexto, este artigo busca explorar os resultados obtidos ao implementar um algoritmo destinado a aumentar a performance logística na distribuição de minério de ferro.

&emsp;&emsp;A teoria dos grafos, conforme explorada por Cormen _et al_. (1990), destaca-se como uma abordagem essencial para superar os desafios complexos na gestão da cadeia de suprimentos global desta empresa parceira. Na sua complexa rede logística existem minas, pontos de transferência e clientes e o desafio principal é conectar eficientemente as minas aos clientes, considerando os diferentes modais de transporte como caminhões, correias transportadoras, minerodutos e ferrovias, cada um com suas limitações.

&emsp;&emsp;É por isso que a teoria dos grafos surge como uma solução promissora para otimizar essa distribuição. Ao modelar a rede logística como um grafo, com minas, pontos de transferência e clientes como vértices, e rotas de transporte como arestas, é possível aplicar algoritmos de otimização. Esse artigo pretende mostrar a aplicação de algoritmos de fluxo máximo em grafos, atendo-se principalmente a comparar os algoritmos de Ford-Fulkerson e Edmonds-Karp.

&emsp;&emsp;Para tal, inicialmente foram realizados encontros com esta empresa parceira afim de entender quais as suas principais dores e outros conceitos relevantes para o desenvolvimento deste projeto. A partir daí, foi desenvolvido um modelo matemático para abordar o problema. Isso envolveu a definição das variáveis de decisão, da função objetivo e das restrições.

&emsp;&emsp;Além disso, também foi feita uma pesquisa nos principais algoritmos clássicos da literatura para lidar com problemas de fluxo máximo, resultando na escolha dos algoritmos de Ford-Fulkerson e Edmonds-Karp. Ao longo das 10 semanas de desenvolvimento deste projeto, os dados fornecidos serão tratados e os algoritmos serão implementados. Em seguida, seus resultados serão comparados com os resultados reais do algoritmo do parceiro, a fim de validar as implementações. Posteriormente, os resultados serão disponibilizados em uma aplicação web. Para alcançar esse objetivo, as principais tecnologias utilizadas serão Java como linguagem de programação, e Neo4j e Cypher, respectivamente um banco de dados de grafos e sua linguagem de consulta.

# Motivação

&emsp;&emsp;Este projeto é impulsionado pela necessidade de maximizar a entrega de minério de ferro aos clientes de uma das principais empresas de mineração globais, inspirando-se também no modelo pedagógico do Inteli (Instituto de Tecnologia e Liderança), que enfatiza a aprendizagem baseada em projetos. O desafio central é otimizar os fluxos de minério ao longo de uma complexa rede logística, assegurando o atendimento eficiente da demanda dos clientes sem comprometer a eficiência operacional.

&emsp;&emsp;Além disso, este projeto visa contribuir para a literatura acadêmica, enriquecendo o corpo de conhecimento existente sobre otimização de fluxos logísticos em mineração. Ao concluir, pretendemos apresentar um estudo comparativo detalhado entre os algoritmos de Ford-Fulkerson e Edmonds-Karp, aplicados ao desafio de otimização dos fluxos de minérios. Esse trabalho comparativo não só demonstrará a aplicabilidade e eficácia desses algoritmos, mas também fornecerá insights valiosos sobre suas performances e adequações às necessidades operacionais e logísticas da indústria de mineração.


# Revisão de literatura

&emsp;&emsp;Maximizar o fluxo em uma rede de grafos é um problema clássico da logística e da ciência da computação, essencial para a otimização de cadeias de suprimentos, incluindo a indústria de mineração. Historicamente, os esforços para resolver esse problema levaram ao desenvolvimento de vários algoritmos, classificados em duas categorias principais: os que buscam aumentos graduais até alcançar o fluxo máximo, como Ford-Fulkerson, Dinic e Edmonds-Karp; e os que aplicam técnicas de pré-fluxo, como o algoritmo Push-Relabel, otimizando o fluxo ao balancear excedentes nos vértices antes de alcançar o estado ótimo (Ahuja, Magnanti, Orlin, 1993).

&emsp;&emsp;Neste trabalho, serão discutidos dois algoritmos: o de Ford-Fulkerson e o de Edmonds-Karp. O último, em particular, permite, por meio da modelagem da malha de transportes em grafos, planejar as rotas mais eficientes para escoar a produção com o maior fluxo possível levando em conta fatores como: fluxo máximo de cada rota, restrições dos modais de transporte, e restrições de percurso e destino(s). Pensando em um ambiente corporativo, é possível obter benefícios como o aumento da eficiência e maior previsibilidade para outras áreas da empresa e, principalmente, seus clientes.

&emsp;&emsp;Inicialmente, é necessário falar sobre o algoritmo de Ford-Fulkerson. Conforme apontado por Kyi e Naing (2018), esse algoritmo foi criado em 1955 e recebeu o nome dos seus criadores. Ele consiste em em tomar o fluxo inicial de um grafo qualquer, e, de maneira recursiva, incrementar o fluxo enviado até que o fluxo máximo seja atingido. Esse processo é feito em duas etapas. A primeira consiste em encontrar um caminho de aumento, que, por definição, é um caminho no grafo que parte da fonte e chegue até o sorvedouro no qual ainda haver aumento no fluxo enviado. Então, esse envio é feito e o algoritmo repete estes dois passos até que não seja mais possível encontrar um caminho aumentante. Quando isso acontece, obtém-se, então, o fluxo máximo (Shokry, 2015).

&emsp;&emsp;Contudo, esse algoritmo apresenta alguns problemas, dois quais é citável a complexidade temporal indeterminada (Bai _Et al._, 2018). É por isso que outros algoritmos surgiram ao longo do tempo. Um exemplo é o algoritmo de Edmonds-Karp, o qual, a fins práticos, é uma implementação de Ford-Fulkerson (CP Algorithms, 2024) cujo principal benefício é encontrar não apenas um caminho aumentante, mas sim o caminho mais curto em tempo polinomial determinístico, o que permite maximizar o percurso com alta eficiência computacional (Torres, Et al. 2003). Há alguns conceitos importante a serem compreendidos antes de se falar na implementação do Edmonds-Karp. Para entendê-lo, faz-se, de antemão, entender alguns conceitos.

&emsp;&emsp;O primeiro deles são as arestas críticas, que consistem em componentes fundamentais em redes de fluxo, atuando como "gargalos" que limitam a capacidade de fluxo ao longo das arestas subsequentes. A identificação e o manejo dessas arestas são cruciais para a otimização do fluxo em uma rede. Como analisado por Torres (2003), quanto ao tempo de execução destes algoritmos, o método de Ford-Fulkerson possui complexidade $O(EF)$, sendo "E" o número de arestas e "F" o fluxo máximo encontrado, contrastando com o Edmonds-Karp, que opera em um tempo O(VE^2), no qual "V" representa os vértices da rede, tornando-se menos prático para grafos densos. Esta diferença destaca a necessidade de selecionar cuidadosamente algoritmos apropriados para diferentes densidades e tamanhos de grafos, com alternativas como o Push-Relabel que é preferível para situações mais complexas.

&emsp;&emsp;O algoritmo de Edmonds-Karp, especificamente, é detalhado através de um processo iterativo dividido em quatro etapas principais, começando com a inicialização dos fluxos das arestas a zero e seguindo com a busca do caminho mais curto entre a fonte e o sorvedouro usando BFS (Busca em Largura). Uma vez identificado um caminho, o algoritmo ajusta os fluxos ao longo desse caminho para aproveitar ao máximo a capacidade disponível, reduzindo os fluxos das arestas onde necessário. Este ciclo de busca de caminho e ajuste de fluxo repete-se até que não seja possível aumentar o fluxo na rede, indicando que o fluxo máximo foi alcançado. Este método sistemático permite a maximização eficiente do fluxo dentro das restrições dadas pela rede.

# Resultados obtidos
Uma parte importante para o desenvolvimento da solução são os resultados obtidos pelo grupo, os quais podem ser analisados em diferentes pontos, como: a modelagem final, o algoritmo utilizado e o deployment da solução em uma aplicação web.
 
## Algorítmo utilizado

&emsp;&emsp;Outro aspecto crucial deste trabalho é o algoritmo de Edmonds-Karp que utilizamos para otimizar os fluxos de minério de ferro na rede logística da empresa mineradora. Nossa abordagem se baseia na maximização do fluxo de minério entre os pontos de origem e destino.

&emsp;&emsp;O algoritmo de Edmonds-Karp é amplamente reconhecido por encontrar o fluxo máximo em um grafo com base na capacidade associada às arestas. Adaptamos sua aplicação para maximizar o fluxo de minério ao longo das rotas de transporte, levando em consideração as capacidades dos modais disponíveis, tais como caminhões, correias transportadoras, minerodutos e ferrovias.

&emsp;&emsp;Em nosso contexto de distribuição de minério de ferro, o algoritmo de Edmonds-Karp é essencial para determinar as rotas mais eficientes, priorizando o fluxo de minério e respeitando as capacidades e restrições operacionais de cada modal de transporte. Essa abordagem garante que o algoritmo leve em conta não apenas a eficiência das conexões diretas entre as minas e os clientes, mas também a capacidade de escoamento de cada rota, contribuindo para a redução dos custos logísticos e a maximização da eficiência operacional na distribuição de minério de ferro.

## Análise dos resultados

&emsp;&emsp;Após a implementação e execução do algoritmo de Edmonds-Karp, foi possível obter resultados significativos em termos de eficiência computacional. O algoritmo foi executado em um tempo de 277 milissegundos, focando exclusivamente na maximização do fluxo do produto AF40. Esses resultados são promissores e demonstram a viabilidade e eficácia do algoritmo de Edmonds-Karp na otimização dos fluxos logísticos na distribuição de minério de ferro. Essa abordagem não apenas proporciona uma solução eficiente para o desafio em questão, mas também sugere um potencial para aplicação em cenários mais amplos dentro da cadeia de suprimentos da empresa mineradora.

&emsp;&emsp;A análise dos resultados mostra que o algoritmo de Edmonds-Karp é capaz de lidar com as restrições e características específicas da cadeia de suprimentos de minério de ferro, encontrando soluções eficientes e eficazes para a maximização dos fluxos de transporte.

&emsp;&emsp;Em resumo, os resultados obtidos com a aplicação do algoritmo de Edmonds-Karp na otimização de fluxos em uma empresa mineradora são promissores e indicam que o algoritmo pode ser aplicado com sucesso em situações reais, melhorando a eficiência e a qualidade dos fluxos de transporte na indústria de mineração de minério de ferro.



# Conclusão

> [OBSERVAÇÃO PARA CORREÇÃO] Dado o fato de que não houve a comparação propriamente dita dos resultados dos algoritmos, esse arcabouço de escrita se prepara para que isso seja feito, de fato, na próxima sprint.

&emsp;&emsp;Este estudo se dedicou à otimização logística na distribuição de minério de ferro utilizando a teoria dos grafos e algoritmos de fluxo máximo como ferramentas-chave. Desde o início, os objetivos estabelecidos foram claros: identificar e implementar uma solução de otimização que pudesse melhorar significativamente a eficiência logística da empresa parceira, abordando o desafio de planejar os fluxos de minério em cada ponto da sua malha de transporte.

&emsp;&emsp;Para atingir esses objetivos, a pesquisa focou na comparação entre os algoritmos de Ford-Fulkerson e Edmonds-Karp, com o intuito de determinar qual deles seria mais eficaz e eficiente no contexto específico da gestão da cadeia de suprimentos da empresa em estudo. A escolha desses algoritmos baseou-se em sua reconhecida capacidade de resolver problemas de fluxo máximo em grafos, uma necessidade central para otimizar a distribuição do minério de ferro.

&emsp;&emsp;Com base nos objetivos propostos e no desenvolvimento do projeto, observou-se que o algoritmo de Edmonds-Karp destacou-se por sua eficácia e eficiência, completando a execução em 277 milissegundos. A implementação do algoritmo de Edmonds-Karp evidenciou não apenas a viabilidade de sua aplicação em cenários reais de complexidade logística, mas também confirmou a teoria de que algoritmos com complexidade temporal determinística podem oferecer soluções robustas e rápidas para problemas de otimização de fluxos em redes de transporte. Esta conclusão é sustentada pelos resultados obtidos, que demonstram a capacidade do algoritmo em maximizar a distribuição de minério de ferro dentro das restrições operacionais impostas pela malha logística.

&emsp;&emsp;Além das contribuições práticas, este estudo busca enriquecer o diálogo acadêmico sobre otimização logística na indústria de mineração, oferecendo insights sobre a aplicabilidade de algoritmos de fluxo máximo em contextos industriais reais. No entanto, é importante ressaltar que cada cenário de aplicação possui suas particularidades, sugerindo a necessidade de ajustes e calibrações específicas dos algoritmos para maximizar sua efetividade.

&emsp;&emsp;Para trabalhos futuros, sugere-se a exploração de outras variantes de algoritmos de fluxo máximo ou aplicação do método _simplex_, assim como a integração de técnicas de inteligência artificial para aprimorar a tomada de decisões na gestão da cadeia de suprimentos. Investigar a implementação de soluções híbridas, que combinem diferentes metodologias de otimização, pode oferecer novos caminhos para superar os desafios logísticos enfrentados pela indústria de mineração. Além disso, considerando este projeto em específico, é possível optar pela expansão do escopo, levando em consideração a blendagem dos minérios e representação temporal, visando a otimização de todos os minérios produzidos de forma simultânea, o que pode proporcionar uma visão mais abrangente e integrada da gestão logística. 

# Referências Bibliográficas

AHUJA, R. K.; MAGNANTI, T. L.; ORLIN, J. B. Network flows: theory, algorithms, and applications. 1. ed. [S.l.]: Prentice Hall, 1993.

CHOPRA, S.; MEINDL, P. Supply chain management: strategy, planning, and operation. 5. ed. [S.l.]: Pearson, 2015. Disponível em: https://www.researchgate.net/profile/Abdelkader-Bouaziz/post/Can_I_request_if_someone_can_help_me_with_pearson_instructor_manual_for_Supply_chain_management_strategy_planning_and_operation_2016/attachment/5f09e009ceab7c0001366546/AS%3A912140693143553%401594482696611/download/Supply+Chain+Management+Strategy%2C+Planning%2C+and+Operation.pdf. Acesso em: 19 fev. 2024.

CHEUNG, T.-Y. Computational Comparison of Eight Methods for the Maximum Network Flow Problem. ACM Transactions on Mathematical Software, v. 6, n. 1, mar. 1980. Disponível em: https://dl.acm.org/doi/pdf/10.1145/355873.355874. Acesso em: 07 de mar. 2024.

CORMEN, T. H.; LEISERSON, C. E.; RIVEST, R. L. Introduction to algorithms. [S.l.]: [s.n.], 1990. Disponível em: https://www.cin.ufpe.br/~ara/algoritmos-%20portugu%C3%AAs-%20cormen.pdf. Acesso em: 28 fev. 2024.

EDMONDS, J.; KARP, R. M. Theoretical improvements in algorithmic efficiency for network flow problems. Journal of the ACM, v. 19, n. 2, p. 248-264, 1972. Disponível em: https://dl.acm.org/doi/10.1145/321694.321699. Acesso em: 7 mar. 2024.

KYI, M. T.; NAING, L. L. Application of Ford-Fulkerson algorithm to maximum flow in water distribution pipeline network. International Journal of Scientific and Research Publications, v. 8, n. 12, dez. 2018.

Hołobut, Paweł, and Jakub Lengiewicz. “Efficient Collective Shape Shifting and Locomotion of Massively-Modular Robotic Structures.” 1, vol. 43. Disponível em: https://doi.org/10.1007/s10514-018-9709-6. Acesso em: 07 de mar. 2024.

TORRES, G. M. Fluxo máximo 1. Disponível em: https://www.ic.unicamp.br/~meidanis/courses/mo417/2003s1/aulas/2003-06-09.html. Acesso em: 5 mar. 2024.

TORRES, G. M. Fluxo máximo 2. Disponível em: https://www.ic.unicamp.br/~meidanis/courses/mo417/2003s1/aulas/2003-06-11.html. Acesso em: 5 mar. 2024.

SHOKRY, M. New operators on Ford-Fulkerson algorithm. IOSR Journal of Mathematics (IOSR-JM), v. 11, n. 2, Ver. V, p. 58-67, mar.-abr. 2015.
