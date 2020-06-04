package com.andrecordeiro.items.repository;

import com.andrecordeiro.items.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

  Iterable<Item> findByNameContainingIgnoreCase(String name);
}
