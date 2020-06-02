package com.andrecordeiro.items.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemsControllerTest {

  @Test
  public void getGreetings() {
    //given
    var itemsController = new ItemsController();

    //when
    var result = itemsController.index();

    //then
    Assertions.assertEquals("Greetings from Spring Boot!", result);
  }
}
