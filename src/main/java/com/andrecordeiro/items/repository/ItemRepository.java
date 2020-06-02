package com.andrecordeiro.items.repository;

import com.andrecordeiro.items.model.Item;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

  List<Item> findByName(String name);

  Item findById(long id);
}
