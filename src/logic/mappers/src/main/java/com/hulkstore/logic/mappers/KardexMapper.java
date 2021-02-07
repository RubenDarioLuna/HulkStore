package com.hulkstore.logic.mappers;

import com.hulkstore.common.entities.Kardex;
import com.hulkstore.logic.dtos.KardexDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class KardexMapper
{
    private static Logger _logger = LoggerFactory.getLogger( KardexMapper.class );

    public static KardexDTO mapEntityToDTO( Kardex entity )
    {
        final KardexDTO dto = new KardexDTO();

        //region Instrumentation
        _logger.debug( "entrando a KardexMapper.mapEntityToDTO: entity {}", entity );
        //endregion

        dto._id = entity.getId();
        dto._amount = entity.getAmount();
        dto._price = entity.getPrice();

        //region Instrumentation
        _logger.debug( "saliendo de KardexMapper.mapEntityToDTO: dto {}", dto );
        //endregion

        return dto;
    }

    public static List<KardexDTO> mapEntityListToDTOList( List<Kardex> entityList )
    {
        final List<KardexDTO> dtoList = new ArrayList<>();

        for ( Kardex entity : entityList )
            dtoList.add( mapEntityToDTO( entity ) );

        return dtoList;
    }
}
