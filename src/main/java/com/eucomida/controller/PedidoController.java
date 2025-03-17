package com.eucomida.controller;

import com.eucomida.anums.StatusEnum;
import com.eucomida.converter.PedidoMapper;
import com.eucomida.dto.PedidoRequest;
import com.eucomida.dto.PedidoResponse;
import com.eucomida.service.PedidoService;
import java.util.Optional;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

  private final PedidoService pedidoService;
  private final PedidoMapper mapper;

  public PedidoController(PedidoService pedidoService, PedidoMapper mapper) {
    this.pedidoService = pedidoService;
    this.mapper = mapper;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public PedidoResponse criarPedido(@RequestBody PedidoRequest request) {
    return Optional.of(pedidoService.criarPedido(mapper.toEntity(request)))
        .map(mapper::toResponse)
        .orElseThrow(() -> new IllegalArgumentException("Erro ao criar pedido"));
  }

  @GetMapping("/{id}/status")
  @ResponseStatus(HttpStatus.OK)
  public StatusEnum consultarStatus(@PathVariable Long id) {
    return Optional.of(mapper.toResponse(pedidoService.buscarPedido(id).get()))
        .map(PedidoResponse::getStatus)
        .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
  }
}
