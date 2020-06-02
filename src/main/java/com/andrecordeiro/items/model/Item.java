package com.andrecordeiro.items.model;

import static javax.persistence.GenerationType.AUTO;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
  @Id
  @GeneratedValue(strategy = AUTO)
  private Long id;

  @Column private UUID uuid;
  @Column private String name;
}
