package com.hulkstore.common.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "brand" )
public class Brand extends MasterEntity
{
    @Column( name = "foundationDate" )
    private LocalDate _foundationDate;

    public Brand()
    {
    }

    public LocalDate getFoundation_date()
    {
        return _foundationDate;
    }

    public void setFoundation_date( LocalDate foundation_date )
    {
        _foundationDate = foundation_date;
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
        Brand brand = ( Brand ) o;
        return Objects.equals( _foundationDate, brand._foundationDate );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _foundationDate );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Brand{" );
        sb.append( "_foundationDate=" ).append( _foundationDate );
        sb.append( '}' );
        return sb.toString();
    }
}
