package com.hulkstore.logic.dtos;

public class ClothesTypeDTO extends MasterDTO
{
    public ProductTypeDTO _productType;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "ClothesTypeDTO{" );
        sb.append( ", _productType=" ).append( _productType );
        sb.append( '}' );
        return sb.toString();
    }
}
