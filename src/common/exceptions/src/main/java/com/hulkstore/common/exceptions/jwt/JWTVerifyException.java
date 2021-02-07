package com.hulkstore.common.exceptions.jwt;

import com.hulkstore.common.exceptions.BaseException;

public class JWTVerifyException extends BaseException
{
    public JWTVerifyException( Exception e, String str )
    {
        super( e, str );
    }
}
