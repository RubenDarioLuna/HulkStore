package com.hulkstore.common.exceptions.jpa;

import com.hulkstore.common.exceptions.BaseException;

public class DeleteException extends BaseException
{
    public DeleteException( Exception e, String str )
    {
        super( e, str );
    }
}
