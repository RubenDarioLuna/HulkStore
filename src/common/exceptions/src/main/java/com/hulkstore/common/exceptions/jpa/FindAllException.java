package com.hulkstore.common.exceptions.jpa;

import com.hulkstore.common.exceptions.BaseException;

public class FindAllException extends BaseException
{
    public FindAllException( Exception e, String str )
    {
        super( e, str );
    }
}
