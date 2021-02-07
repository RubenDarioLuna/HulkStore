package com.hulkstore.logic.mappers;

import com.hulkstore.common.EntityFactory;
import com.hulkstore.common.entities.ClothesType;
import com.hulkstore.common.enums.MasterStatus;
import com.hulkstore.logic.dtos.ClothesTypeDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ClothesTypeMapper
{
    private static Logger _logger = LoggerFactory.getLogger( ClothesTypeMapper.class );

    public static ClothesType mapDTOToEntity( ClothesTypeDTO dto )
    {
        ClothesType entity = EntityFactory.createClothesType();
        final int value = 10;

        //region Instrumentation
        _logger.debug( "entrando a ClothesTypeMapper.mapDTOToEntity: dto {}", dto );
        //endregion

        entity.setId( dto._id );
        entity.setStatus( MasterStatus.valueOf( dto._status) );
        entity.setValue( dto._value );
        entity.setProductType( ProductTypeMapper.mapDTOToEntity( dto._productType) );

        //region Instrumentation
        _logger.debug( "saliendo de ClothesTypeMapper.mapDTOToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static ClothesTypeDTO mapEntityToDTO( ClothesType entity )
    {
        final ClothesTypeDTO dto = new ClothesTypeDTO();

        //region Instrumentation
        _logger.debug( "entrando a ClothesTypeMapper.mapEntityToDTO: entity {}", entity );
        //endregion

        dto._id = entity.getId();
        dto._status = entity.getStatus().getValue();
        dto._value = entity.getValue();
        dto._productType = ProductTypeMapper.mapEntityToDTO( entity.getProductType() );

        //region Instrumentation
        _logger.debug( "saliendo de ClothesTypeMapper.mapEntityToDTO: dto {}", dto );
        //endregion

        return dto;
    }

    public static List<ClothesTypeDTO> mapEntityListToDTOList( List<ClothesType> entityList )
    {
        final List<ClothesTypeDTO> dtoList = new ArrayList<>();

        for ( ClothesType entity : entityList )
            dtoList.add( mapEntityToDTO( entity ) );

        return dtoList;
    }

    public static List<ClothesType> mapDTOListToEntityList( List<ClothesTypeDTO> dtoList )
    {
        final List<ClothesType> entityList = new ArrayList<>();

        for ( ClothesTypeDTO dto : dtoList )
            entityList.add( mapDTOToEntity( dto ) );

        return entityList;
    }
}
