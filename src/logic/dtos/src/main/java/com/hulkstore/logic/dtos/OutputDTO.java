package com.hulkstore.logic.dtos;

public class OutputDTO extends KardexDTO
{
    public String _outputDate;
    public OrderProductDTO _orderProduct;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "OutputDTO{" );
        sb.append( ", _outputDate=" ).append( _outputDate );
        sb.append( ", _orderProduct=" ).append( _orderProduct );
        sb.append( '}' );
        return sb.toString();
    }
}
