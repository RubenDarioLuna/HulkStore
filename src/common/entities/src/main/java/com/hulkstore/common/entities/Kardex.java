package com.hulkstore.common.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Kardex extends BaseEntity
{
    @Column( name = "price", nullable = false )
    private double _price;

    @Column( name = "amount", nullable = false )
    private int _amount;

    public double getPrice()
    {
        return _price;
    }

    public void setPrice( double price )
    {
        _price = price;
    }

    public int getAmount()
    {
        return _amount;
    }

    public void setAmount( int amount )
    {
        _amount = amount;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }
        if ( !super.equals( o ) )
        {
            return false;
        }
        Kardex kardex = ( Kardex ) o;
        return Double.compare( kardex._price, _price ) == 0 && _amount == kardex._amount;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _price, _amount );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Kardex{" );
        sb.append( "_price=" ).append( _price );
        sb.append( "_amount=" ).append( _amount );
        sb.append( '}' );
        return sb.toString();
    }
}
