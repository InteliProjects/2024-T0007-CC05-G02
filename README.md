<table>
<tr>
<td>
<a href= "https://vale.com/pt/"><img src="https://upload.wikimedia.org/wikipedia/pt/c/cc/Logotipo_Vale.svg" alt="Vale" border="0" width="60%"></a>
</td>
<td><a href= "https://www.inteli.edu.br/"><img src="./inteli-logo.png" alt="Inteli - Instituto de Tecnologia e Liderança" border="0" width="40%"></a>
</td>
</tr>
</table>

# Introdução

Este é um dos repositórios do projeto de alunos do Inteli em parceria com a Vale no 1º semestre de 2024. Este projeto está sendo desenvolvido por alunos do Módulo 5 do curso de Ciência da Computação.

# Projeto: Aumento da performance logística na distribuição de minério de ferro

# Grupo: *AK*

# 👨‍🎓 Integrantes:

* [Felipe Liberman Fuchs](linkedin.com/in/fuchsfelipel/)
* [Gabriel Farias Alves](linkedin.com/in/gabriel-farias-alves/)
* [Giovana Katsuki Murata](linkedin.com/in/giovana-katsuki-murata-503a94264/)
* [Maurício de Azevedo Neto](linkedin.com/in/mauricio-azevedo-neto/)
* [Patrick Brett Savoia](linkedin.com/in/patrick-savoia-4b26a126a/)
* [Tommy Ken Ishimatsu Goto](linkedin.com/in/tommygoto/)

# 👩‍🏫 Professores:

## Orientador
* [🧭 Tomaz Mikio Sasaki](linkedin.com/in/tmsasaki/)

## Instrutores
* [📈 Pedro Teberga - Professor de Business](linkedin.com/in/pedroteberga/)
* [👨‍💻 Rafael Will - Professor de Computação](linkedin.com/in/rafael-will-m-de-araujo-20809b18b/)
* [🎨 Sergio Venancio - Professor de Design UX/UI](linkedin.com/in/sergio-venancio-a509b342/)
* [🧮 Maria Cristina - Professora de Matemática](linkedin.com/in/cristinagramani/)
* [👑 Mônica Anastassiu - Professor de Liderança](linkedin.com/in/monica-anastassiu-d-sc-2568522/)


# Descrição 📜

Esta solução tem o objetivo de otimizar a logística na distribuição de minério de ferro. Por meio da modelagem em grafos e utilizando os algoritmos de Ford-Fulkerson e Edmonds-Karp, o projeto visa maximizar o atendimento aos clientes da Vale, considerando as capacidades da malha logística que envolve caminhões, ferrovias, e navios. O escopo se concentra no sistema Sudeste. A solução desenvolvida consiste em uma aplicação web que fornece o fluxo máximo do minério de ferro, permitindo uma melhor avaliação pelos analistas de planejamento de _supply chain_ da Vale.

# Configuração para desenvolvimento

Esta solução consiste em uma aplicação web, dividida em duas partes:**Front-End** e **Back-End**.
 - 🎨 Para instruções sobre o Front-End, [clique aqui](./codigo/frontend/README.md).

 - 🌐 Para instruções sobre o Back-End, [clique aqui](./codigo/Planejador/README.md).

# Releases

* **SPRINT 1**: Esta foi uma sprint focada no entendimento do projeto. Para tanto, foram entregues:
  - Artefato de entendimento de negócios &rarr; Avaliação da empresa Vale e como ela está posicionada no mercado de mineração, matriz de riscos do projeto e breve contextualização da solução;
  - Artefato de UX &rarr; Criação de persona que representa o usuário da solução aqui desenvolvida e suas histórias na jornada do aplicativo;
  - Artefato de matemática &rarr; Criação da modelagem inicial do problema, incluindo variáveis de decisão, função objetivo e restrições.

* **SPRINT 2**: Momento dedicado para o início da programação e escrita do artigo, além de refinamento da modelagem matemática. Entrega de:
  - Artefato de computação &rarr; Implementação das primeiras classes utilizadas na solução;
  - Artigo &rarr; Escrita da introdução do artigo científico escrito durante o decorrer do projeto;
  - Refinamento da modelagem &rarr; Uma melhoria da modelagem matemática feita na sprint 01, com base na correção da professora de matemática.

* **SPRINT 3**: Este foi um período voltado não só para a continuação da escrita do artigo, como também para a implementação de um algoritmo de fluxo máximo e construção inicial do frontend.
  - Artefato de computação &rarr; Implementação do algoritmo de Edmonds Karp, um clássico para resolver problemas de fluxo máximo;
  - Artigo &rarr; Refinamento da metodologia, inclusão da motivação e escrita da revisão de literatura;
  - Frontend &rarr; Criação de uma versão inicial do frontend, utilizada para validar junto com o cliente um fluxo dentro da plataforma e obter insights para continuar o desenvolvimento.

* **SPRINT 4**: Aqui, o objetivo foi realizar a análise dos resultados obtidos com a implementação dos algoritmos clássicos e escrever uma conclusão para o artigo. Bem como continuar o desenvolvimento do front-end. Por fim, também foi feita uma análise matemática do código implementado.
  - Artefato de computação &rarr; Implementação do algoritmo de Ford-Fulkerson e refatoração do código para utilização do framework Spring;
  - Artigo &rarr; Análise de resultados e conclusão;
  - Frontend &rarr; Continuação no desenvolvimento do frontend realizando a plotagem dos nós e arestas na tela.
  - Artefato de matemática &rarr; Demonstração da corretude e análise de complexidade do algoritmo.

* **SPRINT 5**: Por fim, a última sprint foi uma etapa de refinamento. Nela, houve uma revisão e correção final da solução, do artigo científico e do entendimento do negócio.
  - Artefato de computação &rarr; Refatoração do dígrafo para comportar corretamente uma superfonte e supersorvedouro;
  - Artigo &rarr; Revisão e correção final de todos os tópicos;
  - Frontend &rarr; Plotagem dos nós em outra visão (utilizando várias colunas)
  - Artefato de negócios &rarr; Revisão e correção do entendimento do negócio, incluindo Matriz de Risco, Análise SWOT, Análise de 5 forças de Porter, Descrição da Solução e Canvas Proposta de valor.

## 📋 Licença/License

<p xmlns:cc="http://creativecommons.org/ns#" xmlns:dct="http://purl.org/dc/terms/"><a property="dct:title" rel="cc:attributionURL" href="https://github.com/2024M5T7-Inteli/g2">This Work</a> by <a rel="cc:attributionURL dct:creator" property="cc:attributionName" href="https://www.inteli.edu.br/">Inteli, Felipe Liberman Fuchs, Gabriel Farias Alves, Giovana Katsuki Murata, Maurício de Azevedo Neto, Patrick Brett Savoia, Tommy Ken Ishimatsu Goto </a> is licensed under <a href="http://creativecommons.org/licenses/by/4.0/?ref=chooser-v1" target="_blank" rel="license noopener noreferrer" style="display:inline-block;">Attribution 4.0 International<img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/cc.svg?ref=chooser-v1"><img style="height:22px!important;margin-left:3px;vertical-align:text-bottom;" src="https://mirrors.creativecommons.org/presskit/icons/by.svg?ref=chooser-v1"></a></p>