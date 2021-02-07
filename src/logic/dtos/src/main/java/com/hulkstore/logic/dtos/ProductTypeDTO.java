package com.hulkstore.logic.dtos;

public class ProductTypeDTO extends MasterDTO
{
    public String _description;
    public ClothesTypeDTO _clothesType;
    public CrockeryTypeDTO _crockeryType;
    public ToyTypeDTO _toyType;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "ProductTypeDTO{" );
        sb.append( ", _description=" ).append( _description );
        sb.append( ", _clothesType=" ).append( _clothesType );
        sb.append( ", _crockeryType=" ).append( _crockeryType );
        sb.append( ", _toyType=" ).append( _toyType );
        sb.append( '}' );
        return sb.toString();
    }
}
