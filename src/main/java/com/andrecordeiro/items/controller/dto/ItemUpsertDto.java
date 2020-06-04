package com.andrecordeiro.items.controller.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonRootName("ItemUpsert")
public class ItemUpsertDto {

  private String name;
}
