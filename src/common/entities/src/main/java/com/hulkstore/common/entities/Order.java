package com.hulkstore.common.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order extends BaseEntity
{
    @Column( name = "details" )
    private String _details;

    @ManyToOne
    @JoinColumn( name = "idCustomer", nullable = false)
    private Customer _customer;

    @OneToMany( mappedBy = "order" )
    private Set<OrderProduct> _orderProduct;

    public Order()
    {
    }

    public String getDetails()
    {
        return _details;
    }

    public void setDetails( String details )
    {
        _details = details;
    }

    public Customer getCustomer()
    {
        return _customer;
    }

    public void setCustomer( Customer customer )
    {
        _customer = customer;
    }

    public Set<OrderProduct> getOrderProduct()
    {
        return _orderProduct;
    }

    public void setOrderProduct( Set<OrderProduct> orderProduct )
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
        Order order = ( Order ) o;
        return Objects.equals( _details, order._details ) && Objects.equals( _customer, order._customer ) &&
               Objects.equals( _orderProduct, order._orderProduct );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _details, _customer, _orderProduct );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Order{" );
        sb.append( "_details=" ).append( _details );
        sb.append( "_customer=" ).append( _customer );
        sb.append( '}' );
        return sb.toString();
    }
}
