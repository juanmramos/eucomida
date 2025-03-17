package com.eucomida.service;

import com.eucomida.anums.StatusEnum;
import com.eucomida.converter.PedidoMapper;
import com.eucomida.dto.PedidoResponse;
import com.eucomida.entity.PedidoEntity;
import com.eucomida.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
    Optional<PedidoEntity> op = pedidoRepository.findById(id);
    if (op.isPresent()) {
      return op;
    } else {
      throw new IllegalArgumentException("Pedido não encontrado");
    }
  }

  public List<PedidoEntity> listarPedidos() {
    return pedidoRepository.findAll();
  }

  @Transactional
  public PedidoResponse atualizarPedido(Long id, StatusEnum request) {
    PedidoEntity pedido = pedidoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

    if (request.getStatus() != null) {
      pedido.setStatus(request);
    }

    pedidoRepository.save(pedido);

    return new PedidoResponse(pedido.getId(), pedido.getDescricao(), pedido.getStatus()); // Converte para DTO de resposta
  }

  public List<PedidoResponse> listarTodos() {
    List<PedidoResponse> responses = new ArrayList<>();
    pedidoRepository.findAll()
        .forEach(pedido ->
            responses.add(mapper.toResponse(pedido)));
    return responses;
  }
}
