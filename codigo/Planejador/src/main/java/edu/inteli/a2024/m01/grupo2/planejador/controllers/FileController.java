package edu.inteli.a2024.m01.grupo2.planejador.controllers;

import edu.inteli.a2024.m01.grupo2.planejador.models.Aresta;
import edu.inteli.a2024.m01.grupo2.planejador.models.No;
import edu.inteli.a2024.m01.grupo2.planejador.repositories.ArestaRepository;
import edu.inteli.a2024.m01.grupo2.planejador.repositories.NoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para a importação de arquivos CSV para a base de dados
 */
@RestController
@RequestMapping("/files")
public class FileController {
    private final ArestaRepository arestaRepository;
    private final NoRepository noRepository;
    public FileController(ArestaRepository arestaRepository, NoRepository noRepository) {
        this.arestaRepository = arestaRepository;
        this.noRepository = noRepository;
    }


    /**
     * Endpoint para a importação de arquivos CSV para a base de dados.
     * Apaga todo o banco e importa os novos dados de arestas e nós
     *
     * @return Status de Sucesso HTTP Created
     */
    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestParam("arestas") MultipartFile arestasFile, @RequestParam("nos") MultipartFile nosFile) {
        // 1: Deletar todos os dados do banco de dados
        this.arestaRepository.deleteAll();
        this.noRepository.deleteAll();

        // 2: Importar Nós
        List<No> nos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(nosFile.getInputStream()))) {
            importNos(reader, nos);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("CSV de Nós inválido!");
        }

        noRepository.saveAll(nos);

        // 2: Importar Arestas
        List<Aresta> arestas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(nosFile.getInputStream()))) {
            importArestas(reader, arestas);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("CSV de Arestas inválido!");
        }

        arestaRepository.saveAll(arestas);

        return ResponseEntity.status(HttpStatus.CREATED).body("CSV Importado!");
    }

    /**
     * Importa os nós do CSV para a Lista de Nós
     */

    private static void importNos(BufferedReader reader, List<No> nos) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            No no = buildNoFromFields(fields);
            nos.add(no);
        }
    }

    /**
     * Converte uma linha do CSV para um objeto do tipo Nó
     * @return Objeto de Nó
     */

    private static No buildNoFromFields(String[] fields) {
        int id = Integer.parseInt(fields[0]);
        String tipoElo = fields[1];
        int capacidadeMaximaEstocagem = Integer.parseInt(fields[2]);
        String descricao = fields[3];
        boolean temEstoque = Boolean.parseBoolean(fields[4]);

        return new No(id, tipoElo, capacidadeMaximaEstocagem, descricao, temEstoque);
    }

    /**
     * Importa as arestas do CSV para a Lista de Arestas
     */
    private static void importArestas(BufferedReader reader, List<Aresta> arestas) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            Aresta aresta = buildArestaFromFields(fields);
            arestas.add(aresta);
        }
    }

    /**
     * Converte uma linha do CSV para um objeto do tipo Aresta
     * @return Objeto de Aresta
     */
    private static Aresta buildArestaFromFields(String[] fields) {
        String codigoSubModal = fields[0];
        String codigoTipoModal = fields[1];
        String descricao = fields[2];
        int idEloCadeiaProducaoOrigem = Integer.parseInt((fields[3]));
        int idEloCadeiaProducaoDestino  = Integer.parseInt((fields[4]));
        Double pesoMedio = Double.parseDouble((fields[5]));

        return new Aresta(codigoSubModal, codigoTipoModal, descricao, idEloCadeiaProducaoOrigem, idEloCadeiaProducaoDestino, pesoMedio);
    }
}
