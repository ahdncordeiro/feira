package com.andrecordeiro.items.service;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CrudService<T, ID> {

  default <S extends T> S save(S entity) {
    return getRepository().save(entity);
  }

  default <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
    return getRepository().saveAll(entities);
  }

  default Optional<T> findById(ID id) {
    return getRepository().findById(id);
  }

  default boolean existsById(ID id) {
    return getRepository().existsById(id);
  }

  default Iterable<T> findAll() {
    return getRepository().findAll();
  }

  default Iterable<T> findAllById(Iterable<ID> ids) {
    return getRepository().findAllById(ids);
  }

  default long count() {
    return getRepository().count();
  }

  default void deleteById(ID id) {
    getRepository().deleteById(id);
  }

  default void delete(T entity) {
    getRepository().delete(entity);
  }

  default void deleteAll(Iterable<? extends T> entities) {
    getRepository().deleteAll(entities);
  }

  default void deleteAll() {
    getRepository().deleteAll();
  }

  CrudRepository<T, ID> getRepository();
}
