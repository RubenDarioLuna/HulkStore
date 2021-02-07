package com.hulkstore.common.exceptions.jwt;

import com.hulkstore.common.exceptions.BaseException;

public class JWTSetKeyException extends BaseException
{
    public JWTSetKeyException( Exception e, String str )
    {
        super( e, str );
    }
}
