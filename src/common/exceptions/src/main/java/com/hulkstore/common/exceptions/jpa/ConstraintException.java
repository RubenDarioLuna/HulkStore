package com.hulkstore.common.exceptions.jpa;

import com.hulkstore.common.exceptions.BaseException;

public class ConstraintException extends BaseException
{
    public ConstraintException( Exception e, String str )
    {
        super( e, str );
    }
}
