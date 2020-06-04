package com.andrecordeiro.items.controller.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@JsonRootName("Item")
public class ItemDto extends ItemUpsertDto {

  private UUID uuid;
}
