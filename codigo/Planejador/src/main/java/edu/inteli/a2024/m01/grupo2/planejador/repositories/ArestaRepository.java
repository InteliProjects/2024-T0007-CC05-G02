package edu.inteli.a2024.m01.grupo2.planejador.repositories;

import edu.inteli.a2024.m01.grupo2.planejador.models.Aresta;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositório para operações CRUD na entidade Aresta.
 * Extende {@link CrudRepository}, fornecendo métodos CRUD para a entidade
 * Aresta.
 * A Spring Data JPA gerencia a implementação em tempo de execução, permitindo
 * operações como salvar, encontrar, deletar, etc., sem a necessidade de
 * implementação manual.
 */
public interface ArestaRepository extends CrudRepository<Aresta, Integer> {
  // Métodos CRUD para Aresta são automaticamente disponibilizados via herança de
  // CrudRepository

}
