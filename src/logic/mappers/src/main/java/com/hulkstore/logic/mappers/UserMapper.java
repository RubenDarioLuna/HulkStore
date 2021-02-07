package com.hulkstore.logic.mappers;

import com.hulkstore.common.EntityFactory;
import com.hulkstore.common.entities.User;
import com.hulkstore.common.enums.UserStatus;
import com.hulkstore.common.enums.UserType;
import com.hulkstore.logic.dtos.UserDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserMapper
{
    private static Logger _logger = LoggerFactory.getLogger( UserMapper.class );

    public static User mapDTOToEntity( UserDTO dto )
    {
        User entity = EntityFactory.createUser();
        final int value = 10;

        //region Instrumentation
        _logger.debug( "entrando a UserMapper.mapDTOToEntity: dto {}", dto );
        //endregion

        entity.setId( dto._id );
        entity.setToken( dto._token );
        entity.setPassword( dto._password );
        entity.setUserType( UserType.valueOf( dto._userType ) );
        entity.setUserStatus( UserStatus.valueOf( dto._userStatus ) );

        if( dto._name != null )
            entity.setName( dto._name.toLowerCase() );

        if( dto._lastName != null )
            entity.setLastName( dto._lastName.toLowerCase() );

        if( dto._idNumber != null )
            entity.setIdNumber( dto._idNumber.toLowerCase() );

        if ( dto._email != null )
            entity.setEmail( dto._email.toLowerCase() );

        if ( dto._birthdate != null )
            entity.setBirthdate( LocalDate.parse( dto._birthdate ) );

        //region Instrumentation
        _logger.debug( "saliendo de UserMapper.mapDTOToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static UserDTO mapEntityToDTO( User entity )
    {
        final UserDTO dto = new UserDTO();

        //region Instrumentation
        _logger.debug( "entrando a UserMapper.mapEntityToDTO: entity {}", entity );
        //endregion

        entity.decrypt();

        dto._id = entity.getId();
        dto._name = entity.getName();
        dto._lastName = entity.getLastName();
        dto._idNumber = entity.getIdNumber();
        dto._email = entity.getEmail();
        dto._token = entity.getToken();
        dto._userType = entity.getUserType().getValue();
        dto._userStatus = entity.getUserStatus().getValue();

        if ( entity.getBirthdate() != null )
            dto._birthdate = entity.getBirthdate().toString();


        //region Instrumentation
        _logger.debug( "saliendo de UserMapper.mapEntityToDTO: dto {}", dto );
        //endregion

        return dto;
    }

    public static List<UserDTO> mapEntityListToDTOList( List<User> entityList )
    {
        final List<UserDTO> dtoList = new ArrayList<>();

        for ( User entity : entityList )
            dtoList.add( mapEntityToDTO( entity ) );

        return dtoList;
    }

    public static List<User> mapDTOListToEntityList( List<UserDTO> dtoList )
    {
        final List<User> entityList = new ArrayList<>();

        for ( UserDTO dto : dtoList )
            entityList.add( mapDTOToEntity( dto ) );

        return entityList;
    }

}
