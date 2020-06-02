package com.andrecordeiro.items.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsController {

  @RequestMapping("/")
  public String index() {
    return "Greetings from Spring Boot!";
  }
}
