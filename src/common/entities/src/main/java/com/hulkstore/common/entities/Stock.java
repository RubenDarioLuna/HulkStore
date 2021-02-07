package com.hulkstore.common.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "stock" )
public class Stock extends Kardex
{
    @Column( name = "entryDate", nullable = false )
    private LocalDate _entryDate;

    @ManyToOne
    @JoinColumn( name = "idProduct", nullable = false)
    private Product _product;

    public Stock()
    {
    }

    public LocalDate getEntryDate()
    {
        return _entryDate;
    }

    public void setEntryDate( LocalDate entryDate )
    {
        _entryDate = entryDate;
    }

    public Product getProduct()
    {
        return _product;
    }

    public void setProduct( Product product )
    {
        _product = product;
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
        Stock stock = ( Stock ) o;
        return Objects.equals( _entryDate, stock._entryDate ) && Objects.equals( _product, stock._product );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _entryDate, _product );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Stock{" );
        sb.append( "_entryDate=" ).append( _entryDate );
        sb.append( "_product=" ).append( _product );
        sb.append( '}' );
        return sb.toString();
    }
}
