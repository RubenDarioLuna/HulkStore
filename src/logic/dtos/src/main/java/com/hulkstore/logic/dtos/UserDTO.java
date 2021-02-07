package com.hulkstore.logic.dtos;

public class UserDTO
{
    public long _id;
    public String _name;
    public String _lastName;
    public String _birthdate;
    public String _idNumber;
    public String _email;
    public String _registerDate;
    public int _userType;
    public int _userStatus;
    public String _token;
    public String _password;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "UserDTO{" );
        sb.append( "_id=" ).append( _id );
        sb.append( ", _name='" ).append( _name );
        sb.append( ", _lastName='" ).append( _lastName );
        sb.append( ", _birthdate='" ).append( _birthdate );
        sb.append( ", _idNumber='" ).append( _idNumber );
        sb.append( ", _email='" ).append( _email );
        sb.append( ", _token='" ).append( _token );
        sb.append( ", _password='" ).append( _password );
        sb.append( ", _userType=" ).append( _userType );
        sb.append( ", _userStatus=" ).append( _userStatus );
        sb.append( '}' );
        return sb.toString();
    }
}
