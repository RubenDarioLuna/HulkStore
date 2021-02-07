package com.hulkstore.services.implemetantion;

import com.hulkstore.common.utilities.JWT;
import com.hulkstore.common.utilities.Registry;
import com.hulkstore.common.exceptions.registry.ConfigException;
import com.hulkstore.common.exceptions.jwt.JWTVerifyException;
import com.hulkstore.services.contracts.IBaseApplicationService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ApplicationPath( "/api" )
public class BaseApplicationService extends Application implements IBaseApplicationService
{
    private static Logger _logger = LoggerFactory.getLogger( BaseApplicationService.class );

    @Override
    public Set<Class<?>> getClasses()
    {
        final Set<Class<?>> response = new HashSet<>();

        //region Instrumentation DEBUG
        _logger.debug( "Entrando a BaseApplicationService.getClasses" );
        //endregion

        try
        {
            Registry.getInstance();
            response.add( UserService.class );
        }
        catch ( ConfigException e )
        {
            _logger.error( e.getMessage(), e );

            throw new Error( e.getMessage(), e );
        }

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de BaseApplicationService.getClasses" );
        //endregion

        return response;
    }

    private void validateCredentials(String credential, String userId )
    {
        try
        {
            JWT.verifyToken( credential, userId );
        }
        catch ( JWTVerifyException e )
        {
            _logger.error( e.getMessage(), e );
            throwException( Response.Status.UNAUTHORIZED, e );
        }
    }


    void verifyParams( Object object )
    {
        if ( object == null )
            throwException( Response.Status.BAD_REQUEST );
    }

    void throwException( Response.Status status, Exception e )
    {
        throw new WebApplicationException( Response.status( status ).entity( e ).build() );
    }

    void throwException( Response.Status status )
    {
        throw new WebApplicationException( Response.status( status ).build() );
    }
}
