package com.hulkstore.common.enums;

import java.util.HashMap;

public enum UserStatus
{
    UNDEFINED( 0 ),
    ACTIVE( 1 ),
    DELETED( 2 ),
    BLOCKED( 3 );

    private int _value;
    private static HashMap<Integer, UserStatus> _map = new HashMap<>();

    UserStatus( int value )
    {
        _value = value;
    }

    static
    {
        for( UserStatus type : UserStatus.values() )
        {
            _map.put( type._value, type );
        }
    }

    public static UserStatus valueOf( int typeNum )
    {
        UserStatus response = _map.get( typeNum );

        if( response == null )
            throw new IllegalArgumentException( "No enum constant was found for value: " + typeNum );

        return response;
    }

    public int getValue()
    {
        return _value;
    }
}
