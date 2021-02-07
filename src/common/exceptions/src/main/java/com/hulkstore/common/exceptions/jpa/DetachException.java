package com.hulkstore.common.exceptions.jpa;

import com.hulkstore.common.exceptions.BaseException;

public class DetachException extends BaseException
{
    public DetachException( Exception e, String str )
    {
        super( e, str );
    }
}
