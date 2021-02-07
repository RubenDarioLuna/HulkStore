package com.hulkstore.logic.dtos;

public class BrandDTO extends MasterDTO
{
    public String _foundationDate;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "BrandDTO{" );
        sb.append( ", _foundationDate=" ).append( _foundationDate );
        sb.append( '}' );
        return sb.toString();
    }
}
