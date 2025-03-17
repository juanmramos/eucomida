package com.eucomida.converter;

import com.eucomida.dto.PedidoRequest;
import com.eucomida.dto.PedidoResponse;
import com.eucomida.entity.PedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

  PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);


  @Mapping(target = "descricao", source = "description")
  PedidoEntity toEntity(PedidoRequest pedidoRequest);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "description", source = "descricao")
  @Mapping(target = "status", source = "status")
  PedidoResponse toResponse(PedidoEntity pedidoEntity);
}
