package com.hulkstore.common.exceptions.jpa;

import com.hulkstore.common.exceptions.BaseException;

public class UpdateException extends BaseException
{
    public UpdateException( Exception e, String str )
    {
        super( e, str );
    }
}
