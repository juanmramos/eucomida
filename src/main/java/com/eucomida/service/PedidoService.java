package com.eucomida.service;

import com.eucomida.anums.StatusEnum;
import com.eucomida.converter.PedidoMapper;
import com.eucomida.entity.PedidoEntity;
import com.eucomida.repository.PedidoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

  private final PedidoRepository pedidoRepository;
  private final PedidoMapper mapper;

  public PedidoService(PedidoRepository pedidoRepository, PedidoMapper mapper) {
    this.pedidoRepository = pedidoRepository;
    this.mapper = mapper;
  }

  public PedidoEntity criarPedido(PedidoEntity pedido) {
    pedido.setStatus(StatusEnum.EM_ANDAMENTO);
    return pedidoRepository.save(pedido);
  }

  public Optional<PedidoEntity> buscarPedido(Long id) {
    return pedidoRepository.findById(id);
  }

  public List<PedidoEntity> listarPedidos() {
    return pedidoRepository.findAll();
  }
}
