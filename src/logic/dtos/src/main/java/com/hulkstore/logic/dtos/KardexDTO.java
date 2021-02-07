package com.hulkstore.logic.dtos;

public class KardexDTO
{
    public long _id;
    public double _price;
    public int _amount;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "KardexDTO{" );
        sb.append( "_id=" ).append( _id );
        sb.append( ", _price=" ).append( _price );
        sb.append( ", _amount=" ).append( _amount );
        sb.append( '}' );
        return sb.toString();
    }
}
