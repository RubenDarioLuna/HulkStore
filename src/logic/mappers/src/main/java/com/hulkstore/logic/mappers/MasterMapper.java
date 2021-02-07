package com.hulkstore.logic.mappers;

import com.hulkstore.common.EntityFactory;
import com.hulkstore.common.entities.MasterEntity;
import com.hulkstore.common.enums.MasterStatus;
import com.hulkstore.logic.dtos.MasterDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MasterMapper
{
    private static Logger _logger = LoggerFactory.getLogger( MasterMapper.class );

    public static MasterDTO mapEntityToDTO( MasterEntity entity )
    {
        final MasterDTO dto = new MasterDTO();

        //region Instrumentation
        _logger.debug( "entrando a MasterMapper.mapEntityToDTO: entity {}", entity );
        //endregion

        dto._id = entity.getId();
        dto._status = entity.getStatus().getValue();
        dto._value = entity.getValue();

        //region Instrumentation
        _logger.debug( "saliendo de MasterMapper.mapEntityToDTO: dto {}", dto );
        //endregion

        return dto;
    }

    public static List<MasterDTO> mapEntityListToDTOList( List<MasterEntity> entityList )
    {
        final List<MasterDTO> dtoList = new ArrayList<>();

        for ( MasterEntity entity : entityList )
            dtoList.add( mapEntityToDTO( entity ) );

        return dtoList;
    }
}
