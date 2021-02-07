package com.hulkstore.common.exceptions.aes;

import com.hulkstore.common.exceptions.BaseException;

public class AESDecryptException extends BaseException
{
    public AESDecryptException( Exception e, String str )
    {
        super( e, str );
    }
}
