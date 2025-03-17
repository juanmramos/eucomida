package com.eucomida.dto;

import com.eucomida.anums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse {
  private Long id;
  private String description;
  private StatusEnum status;
}
