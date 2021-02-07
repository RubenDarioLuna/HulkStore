package com.hulkstore.common.exceptions.handler;

import com.hulkstore.common.exceptions.BaseException;

public class DBHandlerException extends BaseException
{
    public DBHandlerException( Exception e, String str )
    {
        super( e, str );
    }
}
