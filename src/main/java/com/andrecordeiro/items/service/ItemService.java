package com.andrecordeiro.items.service;

import com.andrecordeiro.items.model.Item;
import com.andrecordeiro.items.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ItemService implements CrudService<Item, Long> {

  private final ItemRepository itemRepository;

  public Iterable<Item> findByNameContainingIgnoreCase(String name) {
    return itemRepository.findByNameContainingIgnoreCase(name);
  }

  @Override
  public CrudRepository<Item, Long> getRepository() {
    return itemRepository;
  }
}
