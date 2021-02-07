package com.hulkstore.common.exceptions.aes;

import com.hulkstore.common.exceptions.BaseException;

public class AESEncryptException extends BaseException
{
    public AESEncryptException( Exception e, String str )
    {
        super( e, str );
    }
}
