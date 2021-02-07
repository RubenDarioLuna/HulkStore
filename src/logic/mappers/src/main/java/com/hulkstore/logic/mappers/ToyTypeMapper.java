package com.hulkstore.logic.mappers;

import com.hulkstore.common.EntityFactory;
import com.hulkstore.common.entities.ToyType;
import com.hulkstore.common.enums.MasterStatus;
import com.hulkstore.logic.dtos.ToyTypeDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ToyTypeMapper
{
    private static Logger _logger = LoggerFactory.getLogger( ToyTypeMapper.class );

    public static ToyType mapDTOToEntity( ToyTypeDTO dto )
    {
        ToyType entity = EntityFactory.createToyType();
        final int value = 10;

        //region Instrumentation
        _logger.debug( "entrando a ToyTypeMapper.mapDTOToEntity: dto {}", dto );
        //endregion

        entity.setId( dto._id );
        entity.setStatus( MasterStatus.valueOf( dto._status) );
        entity.setValue( dto._value );
        entity.setProductType( ProductTypeMapper.mapDTOToEntity( dto._productType) );

        //region Instrumentation
        _logger.debug( "saliendo de ToyTypeMapper.mapDTOToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static ToyTypeDTO mapEntityToDTO( ToyType entity )
    {
        final ToyTypeDTO dto = new ToyTypeDTO();

        //region Instrumentation
        _logger.debug( "entrando a ToyTypeMapper.mapEntityToDTO: entity {}", entity );
        //endregion

        dto._id = entity.getId();
        dto._status = entity.getStatus().getValue();
        dto._value = entity.getValue();
        dto._productType = ProductTypeMapper.mapEntityToDTO( entity.getProductType() );

        //region Instrumentation
        _logger.debug( "saliendo de ToyTypeMapper.mapEntityToDTO: dto {}", dto );
        //endregion

        return dto;
    }

    public static List<ToyTypeDTO> mapEntityListToDTOList( List<ToyType> entityList )
    {
        final List<ToyTypeDTO> dtoList = new ArrayList<>();

        for ( ToyType entity : entityList )
            dtoList.add( mapEntityToDTO( entity ) );

        return dtoList;
    }

    public static List<ToyType> mapDTOListToEntityList( List<ToyTypeDTO> dtoList )
    {
        final List<ToyType> entityList = new ArrayList<>();

        for ( ToyTypeDTO dto : dtoList )
            entityList.add( mapDTOToEntity( dto ) );

        return entityList;
    }
}
