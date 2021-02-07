package com.hulkstore.common.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "clothesType" )
public class CrockeryType extends MasterEntity
{
    @OneToOne
    @JoinColumn( name = "idProductType", nullable = false )
    private ProductType _productType;

    public CrockeryType()
    {
    }

    public ProductType getProductType()
    {
        return _productType;
    }

    public void setProductType( ProductType productType )
    {
        _productType = productType;
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
        CrockeryType that = ( CrockeryType ) o;
        return Objects.equals( _productType, that._productType );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _productType );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "CrockeryType{" );
        sb.append( "_productType=" ).append( _productType );
        sb.append( '}' );
        return sb.toString();
    }
}
