package com.hulkstore.logic.dtos;

public class ToyTypeDTO extends MasterDTO
{
    public ProductTypeDTO _productType;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "CrockeryTypeDTO{" );
        sb.append( ", _productType=" ).append( _productType );
        sb.append( '}' );
        return sb.toString();
    }
}
