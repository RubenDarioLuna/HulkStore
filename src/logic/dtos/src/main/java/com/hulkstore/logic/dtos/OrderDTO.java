package com.hulkstore.logic.dtos;

import java.util.List;

public class OrderDTO
{
    public long _id;
    public String _details;
    public CustomerDTO _customer;
    public List<OrderProductDTO> _orderProductList;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "OrderDTO{" );
        sb.append( "_id=" ).append( _id );
        sb.append( ", _details=" ).append( _details );
        sb.append( ", _customer=" ).append( _customer );
        sb.append( '}' );
        return sb.toString();
    }
}
