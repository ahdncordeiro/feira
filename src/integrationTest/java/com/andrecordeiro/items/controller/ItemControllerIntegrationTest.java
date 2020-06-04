package com.andrecordeiro.items.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.andrecordeiro.AbstractIntegrationTest;
import com.andrecordeiro.items.model.Item;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@AutoConfigureMockMvc
public class ItemControllerIntegrationTest extends AbstractIntegrationTest {

  @Autowired private MockMvc mvc;

  @Test
  public void getItems() throws Exception {
    // when
    MvcResult result = mvc.perform(get("/items").accept(APPLICATION_JSON)).andReturn();

    // then
    Assertions.assertEquals(HttpStatus.OK, HttpStatus.valueOf(result.getResponse().getStatus()));
    List<Item> actual =
        new ObjectMapper()
            .readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
    Assertions.assertIterableEquals(List.of(), actual);
  }
}
