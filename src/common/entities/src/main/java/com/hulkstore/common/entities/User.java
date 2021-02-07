package com.hulkstore.common.entities;

import com.hulkstore.common.enums.UserStatus;
import com.hulkstore.common.enums.UserType;
import com.hulkstore.common.utilities.AES;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table( name = "user" )
@Inheritance( strategy = InheritanceType.JOINED )
public class User extends BaseEntity
{
    @Column( name = "name", nullable = false )
    private String _name;

    @Column( name = "lastName", nullable = false )
    private String _lastName;

    @Column( name = "email", nullable = false, unique = true )
    private String _email;

    @Column( name = "registerDate" )
    private LocalDate _registerDate;

    @Enumerated
    @Column( name = "idUserType", nullable = false )
    private UserType _userType;

    @Enumerated
    @Column( name = "idUserStatus", nullable = false )
    private UserStatus _userStatus;

    @Column( name = "token", nullable = false )
    private String _token;

    @Column( name = "password", nullable = false )
    private String _password;

    public User()
    {
    }

    public User( User user )
    {
        setId( user.getId() );
        setEmail( user.getEmail() );
        setName( user.getName() );
        setLastName( user.getLastName() );
        setPassword( user.getPassword() );
        setRegisterDate( user.getRegisterDate() );
        setToken( user.getToken() );
        setUserStatus( user.getUserStatus() );
        setUserType( user.getUserType() );
    }

    @Override
    public void encrypt()
    {
        if( _userType != UserType.ADMINISTRATOR )
            doEncrypt();
        else
            validateEncrypt();
    }

    @Override
    public void decrypt()
    {
        if ( _userType != UserType.ADMINISTRATOR )
            doDecrypt();
        else
            validateDecrypt();
    }

    private void validateEncrypt()
    {
        _notEncrypted = false;

        doEncrypt();
    }


    private void validateDecrypt()
    {
        if( ! _notEncrypted )
        {
            _notEncrypted = true;

            doDecrypt();
        }
    }

    private void doEncrypt()
    {
        _email = AES.encrypt( _email );
    }

    private void doDecrypt()
    {
        _email = AES.decrypt( _email );
    }

    public String getName()
    {
        return _name;
    }

    public void setName( String name )
    {
        _name = name;
    }

    public String getLastName()
    {
        return _lastName;
    }

    public void setLastName( String lastName )
    {
        _lastName = lastName;
    }

    public String getEmail()
    {
        return _email;
    }

    public void setEmail( String email )
    {
        _email = email;
    }

    public LocalDate getRegisterDate()
    {
        return _registerDate;
    }

    public void setRegisterDate( LocalDate registerDate )
    {
        _registerDate = registerDate;
    }

    public UserType getUserType()
    {
        return _userType;
    }

    public void setUserType( UserType userType )
    {
        _userType = userType;
    }

    public UserStatus getUserStatus()
    {
        return _userStatus;
    }

    public void setUserStatus( UserStatus userStatus )
    {
        _userStatus = userStatus;
    }

    public String getToken()
    {
        return _token;
    }

    public void setToken( String token )
    {
        _token = token;
    }

    public String getPassword()
    {
        return _password;
    }

    public void setPassword( String password )
    {
        _password = password;
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
        User user = ( User ) o;
        return Objects.equals( _name, user._name ) && Objects.equals( _lastName, user._lastName ) &&
               Objects.equals( _email, user._email ) && Objects.equals( _registerDate, user._registerDate ) &&
               _userType == user._userType && _userStatus == user._userStatus &&
               Objects.equals( _token, user._token ) && Objects.equals( _password, user._password );
    }

    @Override
    public int hashCode()
    {
        return Objects
                .hash( super.hashCode(), _name, _lastName, _email, _registerDate, _userType,
                       _userStatus, _token, _password );
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder( "User{" );
        sb.append( super.toString() );
        sb.append( ", _name='" ).append( _name );
        sb.append( ", _lastName='" ).append( _lastName );
        sb.append( ", _email='" ).append( _email );
        sb.append( ", _token='" ).append( _token );
        sb.append( ", _userType=" ).append( _userType );
        sb.append( ", _userStatus=" ).append( _userStatus );
        sb.append( ", _password='" ).append( _password );
        sb.append( '}' );
        return sb.toString();
    }
}
