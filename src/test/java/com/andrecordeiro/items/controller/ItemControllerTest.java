package com.andrecordeiro.items.controller;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

import com.andrecordeiro.items.service.ItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

public class ItemControllerTest {

  @Test
  public void getItems() {
    // given
    var itemServiceMock = Mockito.mock(ItemService.class);
    when(itemServiceMock.findAll()).thenReturn(of());
    var itemController = new ItemController(itemServiceMock, new ModelMapper());

    // when
    var result = itemController.getItems(null);

    // then
    assertIterableEquals(result, of());
  }
}
