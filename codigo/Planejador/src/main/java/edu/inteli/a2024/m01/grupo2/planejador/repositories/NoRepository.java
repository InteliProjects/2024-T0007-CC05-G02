package edu.inteli.a2024.m01.grupo2.planejador.repositories;

import edu.inteli.a2024.m01.grupo2.planejador.models.No;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface do repositório para a entidade No, oferecendo operações CRUD.
 * Extende a interface CrudRepository do Spring Data, proporcionando uma gama de
 * funcionalidades
 * padrão para operações com a entidade No, como salvar, buscar, excluir e
 * contar registros,
 * sem a necessidade de implementar manualmente esses métodos.
 */
public interface NoRepository extends CrudRepository<No, Integer> {
  // Métodos CRUD para No são automaticamente disponibilizados via herança de
  // CrudRepository
}
