package com.hulkstore.logic.dtos;

import java.util.List;

public class ThemeDTO extends MasterDTO
{
    public String _description;
    public List<Character> _characterList;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "ThemeDTO{" );
        sb.append( ", _entryDate=" ).append( _description );
        sb.append( '}' );
        return sb.toString();
    }
}
