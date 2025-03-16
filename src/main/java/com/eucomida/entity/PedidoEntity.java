package com.eucomida.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos", schema = "eucomida")
public class PedidoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String descricao;
  private String status; // "Em andamento", "Entregue", "Cancelado"

  public PedidoEntity() {
  }

  public PedidoEntity(Long id, String descricao, String status) {
    this.id = id;
    this.descricao = descricao;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
