package com.hulkstore.common.exceptions.aes;

import com.hulkstore.common.exceptions.BaseException;

public class AESAlreadyDecryptException extends BaseException
{
    public AESAlreadyDecryptException( Exception e, String str )
    {
        super( e, str );
    }
}
