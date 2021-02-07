package com.hulkstore.common.exceptions;

import java.io.Serializable;

public abstract class BaseException extends RuntimeException implements Serializable
{
    private static final String ERROR_CODE = "INTERNAL_ERROR";
    private static final String DESCRIPTION = "The server encountered an unexpected error while trying to process " +
                                              "the request.";

    public BaseException( Exception e, String str )
    {
        super( str, e );
    }
}

