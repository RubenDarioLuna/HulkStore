package com.hulkstore.common.exceptions.aes;

import com.hulkstore.common.exceptions.BaseException;

public class AESSetKeyException extends BaseException
{
    public AESSetKeyException( Exception e, String str )
    {
        super( e, str );
    }
}
