package com.hulkstore.common.enums;

import java.util.HashMap;

public enum CharacterType
{
    UNDEFINED( 0 ),
    SUPERHERO( 1 ),
    VILLAIN( 2 );

    private int _value;
    private static HashMap<Integer, CharacterType> _map = new HashMap<>();

    CharacterType( int value )
    {
        _value = value;
    }

    static
    {
        for( CharacterType type : CharacterType.values() )
        {
            _map.put( type._value, type );
        }
    }

    public static CharacterType valueOf( int typeNum )
    {
        CharacterType response = _map.get( typeNum );

        if( response == null )
            throw new IllegalArgumentException( "No enum constant was found for value: " + typeNum );

        return response;
    }

    public int getValue()
    {
        return _value;
    }
}
