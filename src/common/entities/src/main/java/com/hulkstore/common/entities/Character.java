package com.hulkstore.common.entities;

import com.hulkstore.common.enums.CharacterType;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "character")
public class Character extends MasterEntity
{
    @Enumerated
    @Column( name = "idCharacterType", nullable = false )
    private CharacterType _characterType;

    @ManyToOne
    @JoinColumn( name = "idBrand", nullable = false)
    private Brand _brand;

    public Character()
    {
    }

    public Brand getBrand()
    {
        return _brand;
    }

    public void setBrand( Brand brand )
    {
        _brand = brand;
    }

    public CharacterType getCharacterType()
    {
        return _characterType;
    }

    public void setCharacterType( CharacterType characterType )
    {
        _characterType = characterType;
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
        Character character = ( Character ) o;
        return _characterType == character._characterType &&
               Objects.equals( _brand, character._brand );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _characterType, _brand );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Character{" );
        sb.append( "_characterType=" ).append( _characterType );
        sb.append( "_brand" ).append( _brand );
        sb.append( '}' );
        return sb.toString();
    }
}
