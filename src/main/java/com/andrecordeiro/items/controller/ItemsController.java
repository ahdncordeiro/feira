package com.andrecordeiro.items.controller;

import com.andrecordeiro.items.model.Item;
import com.andrecordeiro.items.repository.ItemRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ItemsController {

  private final ItemRepository itemRepository;

  @RequestMapping("/")
  public String index() {
    return "Greetings from Spring Boot!";
  }

  @RequestMapping("/list")
  public List<Item> list() {
    Iterable<Item> source = itemRepository.findAll();
    List<Item> target = new ArrayList<>();
    source.forEach(target::add);
    return target;
  }
}
