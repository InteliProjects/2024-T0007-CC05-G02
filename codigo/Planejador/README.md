# Back-end Amigos da Katsuki

Este diretório contém os arquivos do backend do grupo amigos da Katsuki. Ele contém três enpoints principais que foram construídos utilizando o framework Spring. São eles:

- `/nos`: Retornam todos os nós do banco de dados
- `/arestas`: Retornam todas as arestas do banco de dados
- `/edmondsKarp`: Retorna o resultado do fluxo máximo após rodar o algoritmo de EdmondsKarp (ainda em finalização).

## Execução

Para rodar o backend deste projeto, é necessário ter algumas ferramentas instaladas em sua máquina, além de seguir alguns passos para a execução correta. O projeto foi desenvolvido utilizando o framework Spring, portanto, é fundamental ter o Java JDK instalado, assim como o Maven para gerenciar as dependências e executar o projeto. Aqui está um passo-a-passo:

1. Java JDK: Certifique-se de ter o Java JDK na versão 11 ou superior instalado em sua máquina. Para verificar, abra o terminal e digite java -version. Se você não tiver o Java instalado ou se a versão for inferior à necessária, visite https://www.oracle.com/java/technologies/javase-jdk11-downloads.html para fazer o download e instalar a versão adequada

2. Maven: O Maven é essencial para gerenciar as dependências do projeto e para a execução do mesmo. Para verificar se você já tem o Maven instalado, digite mvn -v em seu terminal. Se precisar instalar o Maven, siga as instruções em https://maven.apache.org/install.html

Após a instalação dos pré-requisitos, siga os passos abaixo para configurar e executar o backend do projeto:

1. Clone este repositório

2. Navegue até o Diretório do Backend: Com o terminal aberto, navegue até o diretório do backend do projeto, que é o `codigo/planejador` em relação à raiz desse projeto

3. Instale todas as dependências, executando o comando `mvn clean install`

4. Utilize o comando `mvn spring-boot:ru`n para iniciar a aplicação

5. Com o servidor rodando, você pode acessar a aplicação via navegador ou utilizando uma ferramenta como o Postman para fazer requisições HTTP. O servidor estará disponível em http://localhost:8081.

Pronto! Seguindo esses passos, você terá o backend do projeto rodando localmente em sua máquina.