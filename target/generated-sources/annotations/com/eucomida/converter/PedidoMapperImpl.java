package com.eucomida.converter;

import com.eucomida.dto.PedidoRequest;
import com.eucomida.dto.PedidoResponse;
import com.eucomida.entity.PedidoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-16T22:21:50-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Amazon.com Inc.)"
)
@Component
public class PedidoMapperImpl implements PedidoMapper {

    @Override
    public PedidoEntity toEntity(PedidoRequest pedidoRequest) {
        if ( pedidoRequest == null ) {
            return null;
        }

        PedidoEntity pedidoEntity = new PedidoEntity();

        pedidoEntity.setDescricao( pedidoRequest.getDescription() );

        return pedidoEntity;
    }

    @Override
    public PedidoResponse toResponse(PedidoEntity pedidoEntity) {
        if ( pedidoEntity == null ) {
            return null;
        }

        PedidoResponse pedidoResponse = new PedidoResponse();

        pedidoResponse.setId( pedidoEntity.getId() );
        pedidoResponse.setDescription( pedidoEntity.getDescricao() );
        pedidoResponse.setStatus( pedidoEntity.getStatus() );

        return pedidoResponse;
    }
}
