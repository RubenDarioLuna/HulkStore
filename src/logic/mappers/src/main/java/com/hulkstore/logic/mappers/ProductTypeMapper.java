package com.hulkstore.logic.mappers;

import com.hulkstore.common.EntityFactory;
import com.hulkstore.common.entities.ProductType;
import com.hulkstore.common.enums.MasterStatus;
import com.hulkstore.logic.dtos.ProductTypeDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductTypeMapper
{
    private static Logger _logger = LoggerFactory.getLogger( ProductTypeMapper.class );

    public static ProductType mapDTOToEntity( ProductTypeDTO dto )
    {
        ProductType entity = EntityFactory.createProductType();
        final int value = 10;

        //region Instrumentation
        _logger.debug( "entrando a ProductTypeMapper.mapDTOToEntity: dto {}", dto );
        //endregion

        entity.setId( dto._id );
        entity.setStatus( MasterStatus.valueOf( dto._status) );
        entity.setValue( dto._value );

        //region Instrumentation
        _logger.debug( "saliendo de ProductTypeMapper.mapDTOToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static ProductTypeDTO mapEntityToDTO( ProductType entity )
    {
        final ProductTypeDTO dto = new ProductTypeDTO();

        //region Instrumentation
        _logger.debug( "entrando a ProductTypeMapper.mapEntityToDTO: entity {}", entity );
        //endregion

        entity.decrypt();

        dto._id = entity.getId();
        dto._status = entity.getStatus().getValue();
        dto._value = entity.getValue();

        //region Instrumentation
        _logger.debug( "saliendo de ProductTypeMapper.mapEntityToDTO: dto {}", dto );
        //endregion

        return dto;
    }

    public static List<ProductTypeDTO> mapEntityListToDTOList( List<ProductType> entityList )
    {
        final List<ProductTypeDTO> dtoList = new ArrayList<>();

        for ( ProductType entity : entityList )
            dtoList.add( mapEntityToDTO( entity ) );

        return dtoList;
    }

    public static List<ProductType> mapDTOListToEntityList( List<ProductTypeDTO> dtoList )
    {
        final List<ProductType> entityList = new ArrayList<>();

        for ( ProductTypeDTO dto : dtoList )
            entityList.add( mapDTOToEntity( dto ) );

        return entityList;
    }
}
