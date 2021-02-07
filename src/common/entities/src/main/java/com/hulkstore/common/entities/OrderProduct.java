package com.hulkstore.common.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "orderProduct" )
public class OrderProduct extends BaseEntity
{
    @ManyToOne
    @JoinColumn( name = "idProduct", nullable = false)
    private Product _product;

    @ManyToOne
    @JoinColumn( name = "idOrder", nullable = false)
    private Order _order;

    @OneToMany( mappedBy = "orderProduct" )
    private Set<Output> _outputList;

    public OrderProduct()
    {
    }

    public Product getProduct()
    {
        return _product;
    }

    public void setProduct( Product product )
    {
        _product = product;
    }

    public Order getOrder()
    {
        return _order;
    }

    public void setOrder( Order order )
    {
        _order = order;
    }

    public Set<Output> getOutputList()
    {
        return _outputList;
    }

    public void setOutputList( Set<Output> outputList )
    {
        _outputList = outputList;
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
        OrderProduct that = ( OrderProduct ) o;
        return Objects.equals( _product, that._product ) && Objects.equals( _order, that._order ) &&
               Objects.equals( _outputList, that._outputList );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _product, _order, _outputList );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "OrderProduct{" );
        sb.append( "_product=" ).append( _product );
        sb.append( "_order=" ).append( _order );
        sb.append( '}' );
        return sb.toString();
    }
}

