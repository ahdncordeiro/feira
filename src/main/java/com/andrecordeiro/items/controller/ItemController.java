package com.andrecordeiro.items.controller;

import static java.util.UUID.randomUUID;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import com.andrecordeiro.items.controller.dto.ItemDto;
import com.andrecordeiro.items.controller.dto.ItemUpsertDto;
import com.andrecordeiro.items.controller.exception.NotFoundException;
import com.andrecordeiro.items.model.Item;
import com.andrecordeiro.items.service.ItemService;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/items")
@RestController
@AllArgsConstructor
public class ItemController {

  private final ItemService itemService;
  private final ModelMapper modelMapper;

  /**
   * List Item.
   *
   * @param name Name of Item to filter
   * @return List of Item
   */
  @RequestMapping(method = GET)
  public List<ItemDto> getItems(@RequestParam(value = "name", required = false) String name) {
    List<ItemDto> result = new ArrayList<>();
    if (StringUtils.isEmpty(name)) {
      itemService.findAll().forEach(item -> result.add(modelMapper.map(item, ItemDto.class)));
    } else {
      itemService
          .findByNameContainingIgnoreCase(name)
          .forEach(item -> result.add(modelMapper.map(item, ItemDto.class)));
    }
    return result;
  }

  /**
   * Get Item by ID.
   *
   * @param id ID of Item
   * @return Item
   */
  @RequestMapping(method = GET, path = "/{id}")
  public ItemDto getItemById(@PathVariable Long id) {
    return itemService
        .findById(id)
        .map(item -> modelMapper.map(item, ItemDto.class))
        .orElseThrow(NotFoundException::new);
  }

  /**
   * Save Item.
   *
   * @param newItem Item to be saved
   * @return Saved Item
   */
  @RequestMapping(method = POST)
  public ItemDto postItem(@RequestBody ItemUpsertDto newItem) {
    Item item = Item.builder().name(newItem.getName()).uuid(randomUUID()).build();
    return modelMapper.map(itemService.save(item), ItemDto.class);
  }

  /**
   * Update Item.
   *
   * @param updateItem Item to be updated
   * @param id ID of Item to be updated
   * @return Updated Item
   */
  @RequestMapping(method = PUT, path = "/{id}")
  public ItemDto putItem(@PathVariable Long id, @RequestBody ItemUpsertDto updateItem) {
    Item item = itemService.findById(id).orElseThrow(NotFoundException::new);
    item.setName(updateItem.getName());
    return modelMapper.map(itemService.save(item), ItemDto.class);
  }

  /**
   * Delete Item.
   *
   * @param id ID of Item to be deleted
   */
  @RequestMapping(method = DELETE, path = "/{id}")
  public void deleteItem(@PathVariable Long id) {
    itemService.deleteById(id);
  }
}
