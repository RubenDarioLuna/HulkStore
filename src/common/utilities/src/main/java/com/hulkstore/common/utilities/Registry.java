package com.hulkstore.common.utilities;

import com.hulkstore.common.exceptions.registry.ConfigException;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Name: Registry
 * Description: Clase que extrae y almacena las propiedades del archivo config.properties
 */
public class Registry
{
    static final String JWT_ISSUER = "jwt.issuer";
    static final String JWT_ALGORITHM = "jwt.algorithm";
    static final String JWT_EXPIRATION = "jwt.expiration";

    public static final String DB_TYPE = "db.type";
    public static final String DB_UNIT = "db.unit";
    public static final String DB_JNDI = "db.jndi";
    public static final String DB_URL = "db.url";
    public static final String DB_USER = "db.user";
    public static final String DB_PASSWORD = "db.password";

    public static final String CORS_WEB_ORIGIN = "cors.web.origin";
    public static final String CORS_DEBUG_MODE  = "cors.debug.mode";

    static final String AES_SECRET = "aes.secret";

    private static final String PROPERTIES_FILE = "config.properties";

    private static Logger _logger = LoggerFactory.getLogger( Registry.class );
    private static Registry _instance;

    private Properties _properties;

    /**
     * Name: getProperty
     * Description: Retorna el valor asociado al nombre del atributo entrante o en su defecto null
     *
     * @param key Nombre del atributo
     * @return Valor del atributo
     */
    public String getProperty( String key )
    {
        return _properties.getProperty( key );
    }

    private Registry()
    {
        //region Instrumentation DEBUG
        _logger.debug( "Entrando a Registry.CTOR" );
        //endregion

        try
        {
            _properties = new Properties();
            _properties.load( getClass().getClassLoader().getResourceAsStream( PROPERTIES_FILE ) );
        }
        catch( IOException e )
        {
            throw new ConfigException( e, "Error reading properties from " + PROPERTIES_FILE );
        }

        //region Instrumentation DEBUG
        _logger.debug( "Saliendo de Registry.CTOR: Properties {}", _properties );
        //endregion
    }

    /**
     * Name: getInstance
     * Description: Retorna una instancia creada o nueva de la clase Registry
     *
     * @return Retorna una instancia de la clase Registry
     */
    public static Registry getInstance()
    {
        if ( _instance == null )
            _instance = new Registry();

        return _instance;
    }
}
