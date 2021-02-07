package com.hulkstore.logic.dtos;

import java.util.List;

public class OrderProductDTO
{
    public long _id;
    public ProductDTO _product;
    public OrderDTO _order;
    public List<OutputDTO> _outputList;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "OrderProductDTO{" );
        sb.append( "_id=" ).append( _id );
        sb.append( ", _product=" ).append( _product );
        sb.append( ", _order=" ).append( _order );
        sb.append( '}' );
        return sb.toString();
    }
}
