package com.hulkstore.common.exceptions.jwt;

import com.hulkstore.common.exceptions.BaseException;

public class JWTCreateException extends BaseException
{
    public JWTCreateException( Exception e, String str )
    {
        super( e, str );
    }
}
