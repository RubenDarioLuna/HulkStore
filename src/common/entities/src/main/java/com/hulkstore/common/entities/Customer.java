package com.hulkstore.common.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "customer" )
public class Customer extends User
{
    @OneToMany( mappedBy = "customer" )
    private Set<Order> _orderList;

    public Customer()
    {
    }

    public Customer( User user )
    {
        super( user );
    }

    public Set<Order> getOrderList()
    {
        return _orderList;
    }

    public void setOrderList( Set<Order> orderList )
    {
        _orderList = orderList;
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
        Customer customer = ( Customer ) o;
        return Objects.equals( _orderList, customer._orderList );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _orderList );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Customer{" );
        sb.append( '}' );
        return sb.toString();
    }
}
