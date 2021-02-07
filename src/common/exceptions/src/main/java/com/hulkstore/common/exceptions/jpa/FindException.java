package com.hulkstore.common.exceptions.jpa;

import com.hulkstore.common.exceptions.BaseException;

public class FindException extends BaseException
{
    public FindException( Exception e, String str )
    {
        super( e, str );
    }
}
