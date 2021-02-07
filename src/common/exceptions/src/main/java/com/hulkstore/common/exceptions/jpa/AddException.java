package com.hulkstore.common.exceptions.jpa;

import com.hulkstore.common.exceptions.BaseException;

public class AddException extends BaseException
{
    public AddException( Exception e, String str )
    {
        super( e, str );
    }
}
