package com.hulkstore.common.exceptions.registry;

import com.hulkstore.common.exceptions.BaseException;

public class ConfigException extends BaseException
{
    public ConfigException( Exception e, String str )
    {
        super( e, str );
    }
}
