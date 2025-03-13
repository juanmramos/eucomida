package com.eucomida.service;

import com.eucomida.entity.PedidoEntity;
import com.eucomida.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

  private final PedidoRepository pedidoRepository;

  public PedidoService(PedidoRepository pedidoRepository) {
    this.pedidoRepository = pedidoRepository;
  }

  public PedidoEntity criarPedido(PedidoEntity pedido) {
    pedido.setStatus("Em andamento");
    return pedidoRepository.save(pedido);
  }

  public Optional<PedidoEntity> buscarPedido(Long id) {
    return pedidoRepository.findById(id);
  }

  public List<PedidoEntity> listarPedidos() {
    return pedidoRepository.findAll();
  }
}
