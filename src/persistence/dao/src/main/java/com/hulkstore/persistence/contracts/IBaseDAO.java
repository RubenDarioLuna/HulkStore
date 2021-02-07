package com.hulkstore.persistence.contracts;

import java.util.List;

public interface IBaseDAO<T>
{
    T insert( T entity );

    T update( T entity );

    T delete( T entity );

    List<T> findAll();

    T find( long id );

    void detach( T entity );
}
