package com.hulkstore.logic.mappers;

import com.hulkstore.common.EntityFactory;
import com.hulkstore.common.entities.Brand;
import com.hulkstore.common.enums.MasterStatus;
import com.hulkstore.logic.dtos.BrandDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BrandMapper
{

    private static Logger _logger = LoggerFactory.getLogger( BrandMapper.class );

    public static Brand mapDTOToEntity( BrandDTO dto )
    {
        Brand entity = EntityFactory.createBrand();

        //region Instrumentation
        _logger.debug( "entrando a BrandMapper.mapDTOToEntity: dto {}", dto );
        //endregion

        entity.setId( dto._id );
        entity.setStatus( MasterStatus.valueOf( dto._status) );
        entity.setValue( dto._value );

        if( dto._foundationDate != null )
            entity.setFoundation_date( LocalDate.parse( dto._foundationDate ) );

        //region Instrumentation
        _logger.debug( "saliendo de BrandMapper.mapDTOToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static BrandDTO mapEntityToDTO( Brand entity )
    {
        final BrandDTO dto = new BrandDTO();

        //region Instrumentation
        _logger.debug( "entrando a BrandMapper.mapEntityToDTO: entity {}", entity );
        //endregion

        dto._id = entity.getId();
        dto._status = entity.getStatus().getValue();
        dto._value = entity.getValue();

        if ( entity.getFoundation_date() != null )
            dto._foundationDate = entity.getFoundation_date().toString();


        //region Instrumentation
        _logger.debug( "saliendo de BrandMapper.mapEntityToDTO: dto {}", dto );
        //endregion

        return dto;
    }

    public static List<BrandDTO> mapEntityListToDTOList( List<Brand> entityList )
    {
        final List<BrandDTO> dtoList = new ArrayList<>();

        for ( Brand entity : entityList )
            dtoList.add( mapEntityToDTO( entity ) );

        return dtoList;
    }

    public static List<Brand> mapDTOListToEntityList( List<BrandDTO> dtoList )
    {
        final List<Brand> entityList = new ArrayList<>();

        for ( BrandDTO dto : dtoList )
            entityList.add( mapDTOToEntity( dto ) );

        return entityList;
    }
}
