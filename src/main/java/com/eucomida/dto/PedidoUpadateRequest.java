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
public class PedidoUpadateRequest {

  private StatusEnum status;

}
