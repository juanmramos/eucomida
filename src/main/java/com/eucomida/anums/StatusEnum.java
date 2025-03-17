package com.eucomida.anums;

public enum StatusEnum {
  CANCELADO("Cancelado"),
  EM_ANDAMENTO("Em andamento"),
  FINALIZADO("Entregue");

  private final String status;
  StatusEnum(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }
}
