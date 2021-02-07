package com.hulkstore.logic.dtos;

public class StockDTO extends KardexDTO
{
    public String _entryDate;
    public ProductDTO _product;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "StockDTO{" );
        sb.append( ", _entryDate=" ).append( _entryDate );
        sb.append( ", _product=" ).append( _product );
        sb.append( '}' );
        return sb.toString();
    }
}
