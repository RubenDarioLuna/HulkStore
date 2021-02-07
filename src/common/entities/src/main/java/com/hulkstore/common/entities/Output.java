package com.hulkstore.common.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "output" )
public class Output extends Kardex
{

    @Column( name = "outputDate", nullable = false )
    private LocalDate _outputDate;

    @ManyToOne
    @JoinColumn( name = "idOrderProduct", nullable = false)
    private OrderProduct _orderProduct;

    public Output()
    {
    }

    public LocalDate getOutputDate()
    {
        return _outputDate;
    }

    public void setOutputDate( LocalDate outputDate )
    {
        _outputDate = outputDate;
    }

    public OrderProduct getOrderProduct()
    {
        return _orderProduct;
    }

    public void setOrderProduct( OrderProduct orderProduct )
    {
        _orderProduct = orderProduct;
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
        Output output = ( Output ) o;
        return Objects.equals( _outputDate, output._outputDate ) &&
               Objects.equals( _orderProduct, output._orderProduct );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _outputDate, _orderProduct );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Output{" );
        sb.append( "_outputDate=" ).append( _outputDate );
        sb.append( "_orderProduct=" ).append( _orderProduct );
        sb.append( '}' );
        return sb.toString();
    }
}
