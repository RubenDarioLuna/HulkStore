package com.hulkstore.logic.dtos;

public class CharacterDTO extends MasterDTO
{
    public int _characterType;
    public BrandDTO _brand;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "CharacterDTO{" );
        sb.append( ", _characterType=" ).append( _characterType );
        sb.append( ", _brand=" ).append( _brand );
        sb.append( '}' );
        return sb.toString();
    }
}
