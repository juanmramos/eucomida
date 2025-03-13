package com.eucomida.controller;

import com.eucomida.entity.PedidoEntity;
import com.eucomida.service.PedidoService;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

  private final PedidoService pedidoService;

  public PedidoController(PedidoService pedidoService) {
    this.pedidoService = pedidoService;
  }

  @PostMapping
  public ResponseEntity<PedidoEntity> criarPedido(@RequestBody PedidoEntity pedido) {
    return ResponseEntity.ok(pedidoService.criarPedido(pedido));
  }

  @GetMapping("/{id}/status")
  public ResponseEntity<String> consultarStatus(@PathVariable Long id) {
    Optional<PedidoEntity> pedido = pedidoService.buscarPedido(id);
    return pedido.map(p -> ResponseEntity.ok(p.getStatus()))
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}
