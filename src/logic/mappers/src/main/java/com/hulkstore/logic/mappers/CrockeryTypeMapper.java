package com.hulkstore.logic.mappers;

import com.hulkstore.common.EntityFactory;
import com.hulkstore.common.entities.CrockeryType;
import com.hulkstore.common.enums.MasterStatus;
import com.hulkstore.logic.dtos.CrockeryTypeDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CrockeryTypeMapper
{
    private static Logger _logger = LoggerFactory.getLogger( CrockeryTypeMapper.class );

    public static CrockeryType mapDTOToEntity( CrockeryTypeDTO dto )
    {
        CrockeryType entity = EntityFactory.createCrockeryType();
        final int value = 10;

        //region Instrumentation
        _logger.debug( "entrando a CrockeryTypeMapper.mapDTOToEntity: dto {}", dto );
        //endregion

        entity.setId( dto._id );
        entity.setStatus( MasterStatus.valueOf( dto._status) );
        entity.setValue( dto._value );
        entity.setProductType( ProductTypeMapper.mapDTOToEntity( dto._productType) );

        //region Instrumentation
        _logger.debug( "saliendo de CrockeryTypeMapper.mapDTOToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static CrockeryTypeDTO mapEntityToDTO( CrockeryType entity )
    {
        final CrockeryTypeDTO dto = new CrockeryTypeDTO();

        //region Instrumentation
        _logger.debug( "entrando a CrockeryTypeMapper.mapEntityToDTO: entity {}", entity );
        //endregion

        dto._id = entity.getId();
        dto._status = entity.getStatus().getValue();
        dto._value = entity.getValue();
        dto._productType = ProductTypeMapper.mapEntityToDTO( entity.getProductType() );

        //region Instrumentation
        _logger.debug( "saliendo de CrockeryTypeMapperer.mapEntityToDTO: dto {}", dto );
        //endregion

        return dto;
    }

    public static List<CrockeryTypeDTO> mapEntityListToDTOList( List<CrockeryType> entityList )
    {
        final List<CrockeryTypeDTO> dtoList = new ArrayList<>();

        for ( CrockeryType entity : entityList )
            dtoList.add( mapEntityToDTO( entity ) );

        return dtoList;
    }

    public static List<CrockeryType> mapDTOListToEntityList( List<CrockeryTypeDTO> dtoList )
    {
        final List<CrockeryType> entityList = new ArrayList<>();

        for ( CrockeryTypeDTO dto : dtoList )
            entityList.add( mapDTOToEntity( dto ) );

        return entityList;
    }
}
