package com.hulkstore.common.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "productType" )
public class ProductType extends MasterEntity
{
    @Column( name = "description" )
    private String _description;

    @OneToOne( mappedBy = "clothesType" )
    private ClothesType _clothesType;

    @OneToOne( mappedBy = "crockeryType" )
    private CrockeryType _crockeryType;

    @OneToOne( mappedBy = "toyType" )
    private ToyType _toyType;

    public ProductType()
    {
    }

    public String getDescription()
    {
        return _description;
    }

    public void setDescription( String description )
    {
        _description = description;
    }

    public ClothesType getClothesType()
    {
        return _clothesType;
    }

    public void setClothesType( ClothesType clothesType )
    {
        _clothesType = clothesType;
    }

    public CrockeryType getCrockeryType()
    {
        return _crockeryType;
    }

    public void setCrockeryType( CrockeryType crockeryType )
    {
        _crockeryType = crockeryType;
    }

    public ToyType getToyType()
    {
        return _toyType;
    }

    public void setToyType( ToyType toyType )
    {
        _toyType = toyType;
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
        ProductType that = ( ProductType ) o;
        return Objects.equals( _description, that._description ) &&
               Objects.equals( _clothesType, that._clothesType ) &&
               Objects.equals( _crockeryType, that._crockeryType ) && Objects.equals( _toyType, that._toyType );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _description, _clothesType, _crockeryType, _toyType );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "ProductType{" );
        sb.append( "_description=" ).append( _description );
        sb.append( "_clothesType=" ).append( _clothesType );
        sb.append( "_crockeryType=" ).append( _crockeryType );
        sb.append( "_toyType=" ).append( _toyType );
        sb.append( '}' );
        return sb.toString();
    }
}
