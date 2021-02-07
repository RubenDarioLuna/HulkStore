package com.hulkstore.common.entities;

import java.util.Objects;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table( name = "theme" )
public class Theme extends MasterEntity
{
    @Column( name = "description" )
    private String _description;

    @ManyToMany
    @JoinTable( name = "themeCharacter",
            joinColumns = @JoinColumn( name = "idTheme" ),
            inverseJoinColumns = @JoinColumn( name = "idCharacter" ) )
    private Set<Character> _characterList;

    public Theme()
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

    public Set<Character> getCharacterList()
    {
        return _characterList;
    }

    public void setCharacterList( Set<Character> characterList )
    {
        _characterList = characterList;
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
        Theme theme = ( Theme ) o;
        return Objects.equals( _description, theme._description ) &&
               Objects.equals( _characterList, theme._characterList );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( super.hashCode(), _description, _characterList );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "Theme{" );
        sb.append( "_description=" ).append( _description );
        sb.append( '}' );
        return sb.toString();
    }
}
