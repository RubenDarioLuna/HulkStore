package com.hulkstore.logic.dtos;

import java.util.List;

public class CustomerDTO extends UserDTO
{
    public String _nickname;
    public List<OrderDTO> _orderList;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "CustomerDTO{" );
        sb.append( ", _nickname=" ).append( _nickname );
        sb.append( '}' );
        return sb.toString();
    }
}
